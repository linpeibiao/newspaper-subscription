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
    public Map<String, String> login(LoginInfo loginInfo) {
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
        return 0;
    }

    @Override
    public int update(Long id) {
        return 0;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }
}
