package com.zkxg.newspaper_subscription.service.impl;

import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.dao.BaseDao;
import com.zkxg.newspaper_subscription.dao.UserDao;
import com.zkxg.newspaper_subscription.dao.impl.UserDaoImpl;
import com.zkxg.newspaper_subscription.exception.BusinessException;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
import com.zkxg.newspaper_subscription.service.UserService;
import com.zkxg.newspaper_subscription.util.MD5EncryptUtil;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaohu
 * @date 2022/10/11/ 15:02
 * @description
 */
public class UserServiceImpl implements UserService {
    // 引入数据操作层接口
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    // 密码加密盐值
    private final String SALT = "love";

    @Override
    public List<User> getUserPage(int pageNum, int pageSize) {
        Connection conn = null;
        List<User> userList = null;
        try {
            conn = BaseDao.getConnection();
            userList = userDao.getUserPage(conn, pageNum, pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            BaseDao.closeResource(conn,null,null);
        }
        System.out.println("Service获取用户列表成功!");
        return userList;
    }

    @Override
    public Map<String, User> login(LoginInfo loginInfo) {
        // 判空
        // TODO 添加手机号登陆逻辑判断
        String account = loginInfo.getAccount();
        String phone = loginInfo.getPhone();
        String loginPassword = loginInfo.getPassword();
        if (StringUtils.isAnyEmpty(account, loginPassword)){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        // 长度限制判断
        if (account.length() > 16 || account.length() < 4){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号应为4-16个字符");
        }
        if (loginPassword.length() > 16 || loginPassword.length() < 8){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码应为8-16个字符");
        }

        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            // 通过账号获取User
            User user = userDao.getUserByAccount(conn, account);
            if (user == null){
                return null;
            }
            // 账号不为空，匹配密码
            // 首先加密, 不要忘记加SALT
            String encryptPassword = MD5EncryptUtil.string2MD5(SALT + loginPassword);
            // 不能使用 == 判断
            if (!encryptPassword.equals(user.getPassword())){
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码不正确");
            }
            // 密码脱敏
            user.setPassword("");
            // 创建map, 将密码作为key,user 对象作为 value 返回
            Map<String, User> map = new HashMap<>();
            map.put(account, user);
            return map;

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn, null, null);
        }

        return null;
    }

    @Override
    public boolean checkAccountExist(String account) {
        if (account == null){
            return false;
        }
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            return userDao.getUserByAccount(conn, account) != null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            BaseDao.closeResource(conn, null, null);
        }
    }

    // 相当于注册
    @Override
    public int add(User user) {
        // 判空
        if (null == user){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号密码不能为空");
        }
        String account = user.getAccount();
        String password = user.getPassword();
        String nackname = user.getNackname();
        String realName = user.getRealName();
        if (StringUtils.isAnyEmpty(account, password, realName)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "有必要参数为空,请补全信息");
        }

        // 长度限制判断
        if (account.length() > 16 || account.length() < 4){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号应为4-16个字符");
        }
        if (password.length() > 16 || password.length() < 8){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码应为8-16个字符");
        }
        if (nackname.length() > 16 || nackname.length() < 4){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "昵称应为4-16个字符");
        }
        if (realName.length() > 16 || realName.length() < 2){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请正确填写姓名");
        }

        // 账号应该唯一
        if (checkAccountExist(account)){
            // 存在就不能添加
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "该账号已存在");
        }

        // 密码进行加密
        String encryptPassword = MD5EncryptUtil.string2MD5(SALT + password);
        user.setPassword(encryptPassword);

        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);
            int rs = userDao.add(conn,user);
            // 要作为事务进行数据库操作
            conn.commit();
            if (rs > 0){
                System.out.println("user is added successfully.....");
                return rs;
            }else{
                //插入失败
                System.out.println("user is added failed");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //出现异常，要对事务进行回滚
            try {
                System.out.println("rollback·····················");
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally{
            //关闭资源
            BaseDao.closeResource(conn,null,null);
        }

        return -1;
    }

    @Override
    public int delete(Long id) {
        if (id == null || id <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Connection conn = null;
        try{
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);
            final int delete = userDao.delete(conn, id);
            conn.commit();
            if (delete > 0){
                return delete;
            }
        }catch (SQLException e){
            // 出现异常，事务回滚
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn, null, null);
        }
        return 0;
    }

    @Override
    public int update(User user) {
        if (user == null){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        // 不修改账号和密码
        String nackname = user.getNackname();
        String realName = user.getRealName();
        if (StringUtils.isAnyEmpty(nackname, realName)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "有必要参数为空,请补全信息");
        }
        // 判断修改字段长度限制
        // 长度限制判断
        if (nackname.length() > 16 || nackname.length() < 4){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "昵称应为4-16个字符");
        }
        if (realName.length() > 16 || realName.length() < 2){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请正确填写姓名");
        }
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);
            int rs = userDao.update(conn, user);
            // 要作为事务进行数据库操作
            conn.commit();
            if (rs > 0){
                System.out.println("user is updated successfully.....");
                return rs;
            }else{
                //插入失败
                System.out.println("user is updated failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //出现异常，要对事务进行回滚
            try {
                System.out.println("rollback·····················");
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally{
            //关闭资源
            BaseDao.closeResource(conn,null,null);
        }


        return 0;
    }

    @Override
    public User getUser(Long id) {
        if (id == null || id <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Connection conn = null;
        User user = null;
        try {
            conn = BaseDao.getConnection();
            user = userDao.getUser(conn, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(conn, null, null);
        }
        return user;
    }
}
