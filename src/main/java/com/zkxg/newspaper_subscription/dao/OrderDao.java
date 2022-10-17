package com.zkxg.newspaper_subscription.dao;

import com.zkxg.newspaper_subscription.model.entity.Order;
import com.zkxg.newspaper_subscription.model.vo.NewspaperInfo;
import com.zkxg.newspaper_subscription.model.vo.UserInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
    // 根据UserId
    List<Order> getOrderByUserId(Connection conn, Long UserId) throws SQLException;
    // 根据订单号
    Order getOrderByOrderNumber(Connection conn, String orderNumber) throws SQLException;
    // 通过报刊ID获取该报刊被订阅的总数量
    int getCountByNewspaperId(Connection conn, Long newspaperId) throws SQLException;
    // 查询花钱第n多的用户
    List<UserInfo> getCostMostUser(Connection conn, int n) throws SQLException;
    // 查询订单数前n的用户
    List<UserInfo> getOrderMostUser(Connection conn, int n) throws SQLException;
    // 查询不同时间阶段内受欢迎程度的报刊信息
    // TODO 给创建时间添加索引，而且在查询的时候一定要按照标准格式，否则索引会失效
    List<NewspaperInfo> getPopularNewspaper(Connection conn, String start, String end, int n) throws SQLException;
}
