package com.zkxg.newspaper_subscription.dao;

import com.zkxg.newspaper_subscription.model.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xiaohu
 * @date 2022/10/11/ 10:49
 * @description 用户dao层接口
 */
public interface UserDao {
    // 获取用户列表
    List<User> getUserPage(Connection conn, int pageNum, int pageSize) throws SQLException;
    // 根据用户账号获取
    User getUserByAccount(Connection conn, String account) throws SQLException;
    // 增
    int add(Connection conn, User user) throws SQLException;
    // 删
    // 根据id
    int delete(Connection conn, Long id) throws SQLException;

    // 改
    // 根据id
    int update(Connection conn, User user) throws SQLException;
    // 查
    // 根据id
    User getUser(Connection conn, Long id) throws SQLException;
}
