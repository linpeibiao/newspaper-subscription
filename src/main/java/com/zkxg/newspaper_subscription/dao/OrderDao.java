package com.zkxg.newspaper_subscription.dao;

import com.zkxg.newspaper_subscription.model.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author xiaohu
 * @date 2022/10/11/ 10:58
 * @description 订单dao层接口
 */
public interface OrderDao {
    // 增
    int add(Connection conn, Order order) throws SQLException;
    // 删
    // 根据id
    int delete(Connection conn, Long id) throws SQLException;
    // 改
    // 根据id
    int update(Connection conn, Long id) throws SQLException;
    // 查
    // 根据id
    Order getOrder(Connection conn, Long id) throws SQLException;
    // 根据订单号
    Order getOrderByOrderNumber(Connection conn, String orderNumber) throws SQLException;
}
