package com.zkxg.newspaper_subscription.dao.impl;

import com.mysql.cj.util.StringUtils;
import com.zkxg.newspaper_subscription.dao.BaseDao;
import com.zkxg.newspaper_subscription.dao.UserDao;
import com.zkxg.newspaper_subscription.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xiaohu
 * @date 2022/10/11/ 10:49
 * @description 用户 dao 层实现类
 */
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getUserPage(Connection conn, int pageNum, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        if (null != conn){
            // 在mysql数据库中，分页使用 limit startIndex，pageSize ; 总数
            String sql = "select * from t_user where is_deleted = 0 limit ?,?";

            Object[] params = new Object[]{
                    pageNum,
                    pageSize
            };
            System.out.println("getUserList()----->"+sql);
            //查询
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            // 信息要脱敏，密码就不能暴露出去了
            while (rs.next()){
                User _user = new User();
                _user.setId(rs.getLong("id"));
                _user.setAccount(rs.getString("account"));
                _user.setNackname(rs.getString("nackname"));
                _user.setAvatar(rs.getString("avatar"));
                _user.setGender(rs.getInt("gender"));
                _user.setPhone(rs.getString("phone"));
                _user.setEmail(rs.getString("email"));
                _user.setRealName(rs.getString("real_name"));
                _user.setDepartment(rs.getString("department"));
                _user.setAddress(rs.getString("address"));
                _user.setPostcode(rs.getString("postcode"));
                _user.setRemark(rs.getString("remark"));
                _user.setState(rs.getInt("state"));
                _user.setRole(rs.getInt("role"));
                userList.add(_user);
            }
            //关闭资源
            BaseDao.closeResource(null,pstm,rs);
            System.out.println("dao方法获取用户表单成功");
        }
        return userList;
    }

    @Override
    public User getUserByAccount(Connection conn, String account) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if (conn != null){
            // TODO 给 account 字段加上唯一性索引
            String sql = "select * from t_user where account = ? and is_deleted=0";
            Object[] params = new Object[]{account};
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            // 返回的信息一定要脱敏
            while(rs.next()){
                user = new User();
                user.setId(rs.getLong("id"));
                user.setAccount(rs.getString("account"));
                user.setPassword(rs.getString("password"));
                user.setNackname(rs.getString("nackname"));
                user.setAvatar(rs.getString("avatar"));
                user.setGender(rs.getInt("gender"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setRealName(rs.getString("real_name"));
                user.setDepartment(rs.getString("department"));
                user.setAddress(rs.getString("address"));
                user.setPostcode(rs.getString("postcode"));
                user.setState(rs.getInt("state"));
                user.setRole(rs.getInt("role"));
                user.setRemark(rs.getString("remark"));
            }
            System.out.println("UserDao通过账号获取用户信息成功");
        }
        BaseDao.closeResource(null,pstm,rs);
        return user;
    }

    @Override
    public int add(Connection conn, User user) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (conn != null) {
            // 17个字段，id自增不用插入
            String sql = "insert into t_user (account,password,nackname," +
                    "avatar,gender,phone,email,real_name,department," +
                    "address,postcode,state,role,remark,is_deleted," +
                    "create_time,update_time) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // 设置系统插入的值
            user.setState(0);// 0 是正常状态
            user.setRole(0);// 0是普通角色
            user.setDeleted(0);// 0 未删除
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            Object params[] = new Object[]{
                user.getAccount(),
                user.getPassword(),
                user.getNackname(),
                user.getAvatar(),
                user.getGender(),
                user.getPhone(),
                user.getEmail(),
                user.getRealName(),
                user.getDepartment(),
                user.getAddress(),
                user.getPostcode(),
                user.getState(),
                user.getRole(),
                user.getRemark(),
                user.getDeleted(),
                user.getCreateTime(),
                user.getUpdateTime()

            };
            //执行sql语句
            updateRows = BaseDao.execute(conn, pstm, sql, params);
            //关闭资源
            BaseDao.closeResource(null, pstm, null);
            System.out.println("UserDao添加用户信息成功");
        }
        return updateRows;
    }

    @Override
    public int delete(Connection conn, Long id) {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (conn != null) {
            //
            String sql = "update t_user set is_deleted=1 where id=?";
            Object params[] = new Object[]{
                    id
            };
            //执行sql语句
            updateRows = BaseDao.execute(conn, pstm, sql, params);
            //关闭资源
            BaseDao.closeResource(null, pstm, null);
            System.out.println("UserDao修改用户信息成功");
        }
        return updateRows;
    }

    @Override
    public int update(Connection conn, User user) {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (conn != null) {
            //
            String sql = "update t_user set nackname=?," +
                    "avatar=?,gender=?,phone=?,email=?,real_name=?,department=?," +
                    "address=?,postcode=?,remark=?,update_time=? " +
                    "where id=? and is_deleted=0";
            // 设置系统自动更新的值
            user.setUpdateTime(new Date());
            Object params[] = new Object[]{
                    user.getNackname(),
                    user.getAvatar(),
                    user.getGender(),
                    user.getPhone(),
                    user.getEmail(),
                    user.getRealName(),
                    user.getDepartment(),
                    user.getAddress(),
                    user.getPostcode(),
                    user.getRemark(),
                    user.getUpdateTime(),
                    user.getId()
            };
            //执行sql语句
            updateRows = BaseDao.execute(conn, pstm, sql, params);
            //关闭资源
            BaseDao.closeResource(null, pstm, null);
            System.out.println("UserDao修改用户信息成功");
        }
        return updateRows;
    }

    @Override
    public User getUser(Connection conn, Long id) throws SQLException{
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if (conn != null){
            String sql = "select * from t_user where id = ? and is_deleted=0";
            Object[] params = new Object[]{id};
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            // 返回的信息一定要脱敏
            while(rs.next()){
                user = new User();
                user.setId(rs.getLong("id"));
                user.setAccount(rs.getString("account"));
                user.setNackname(rs.getString("nackname"));
                user.setAvatar(rs.getString("avatar"));
                user.setGender(rs.getInt("gender"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setRealName(rs.getString("real_name"));
                user.setDepartment(rs.getString("department"));
                user.setAddress(rs.getString("address"));
                user.setPostcode(rs.getString("postcode"));
                user.setState(rs.getInt("state"));
                user.setRole(rs.getInt("role"));
                user.setRemark(rs.getString("remark"));
            }
            System.out.println("UserDao通过id获取用户信息成功");
        }
        BaseDao.closeResource(null,pstm,rs);
        return user;
    }
}
