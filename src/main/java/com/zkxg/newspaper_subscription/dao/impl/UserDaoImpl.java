package com.zkxg.newspaper_subscription.dao.impl;

import com.zkxg.newspaper_subscription.dao.BaseDao;
import com.zkxg.newspaper_subscription.dao.UserDao;
import com.zkxg.newspaper_subscription.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author xiaohu
 * @date 2022/10/11/ 10:49
 * @description 用户 dao 层实现类
 */
public class UserDaoImpl implements UserDao {

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
                user.setRemark(rs.getString("remark"));
            }
            System.out.println("UserDao通过id获取用户信息成功");
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
        return 0;
    }

    @Override
    public int update(Connection conn, Long id) {
        return 0;
    }

    @Override
    public User getUser(Connection conn, Long id) {
        return null;
    }
}
