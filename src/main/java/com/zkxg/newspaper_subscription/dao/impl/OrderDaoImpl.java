package com.zkxg.newspaper_subscription.dao.impl;

import com.zkxg.newspaper_subscription.dao.BaseDao;
import com.zkxg.newspaper_subscription.dao.OrderDao;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;
import com.zkxg.newspaper_subscription.model.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaohu
 * @date 2022/10/11/ 11:00
 * @description 订单dao操作层实现类
 */
public class OrderDaoImpl implements OrderDao {

    @Override
    public int add(Connection conn, Order order) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (conn != null) {
            // 12个字段，id自增不用插入
            String sql = "insert into t_order (order_number,user_id,newspaper_id,user_name,newspaper_name," +
                    "period,subscript_unit,count,total_price,expiry_time,remark,is_deleted," +
                    "create_time,update_time) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Object params[] = new Object[]{
                    order.getOrderNumber(),
                    order.getUserId(),
                    order.getNewspaperId(),
                    order.getUserName(),
                    order.getNewspaperName(),
                    order.getPeriod(),
                    order.getSubscriptUnit(),
                    order.getCount(),
                    order.getTotalPrice(),
                    order.getExpiryTime(),
                    order.getRemark(),
                    order.getDeleted(),
                    order.getCreateTime(),
                    order.getUpdateTime()
            };

            //执行sql语句
            updateRows = BaseDao.execute(conn, pstm, sql, params);
            //关闭资源
            BaseDao.closeResource(null, pstm, null);
            System.out.println("OrderDao添加订单信息成功");
        }
        return updateRows;
    }

    @Override
    public int delete(Connection conn, Long id) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (conn != null) {
            //
            String sql = "update t_order set is_deleted=1 where id=?";
            Object params[] = new Object[]{
                    id
            };
            //执行sql语句
            updateRows = BaseDao.execute(conn, pstm, sql, params);
            //关闭资源
            BaseDao.closeResource(null, pstm, null);
            System.out.println("OrderDao 删除订单信息成功");
        }
        return updateRows;
    }

    @Override
    public int update(Connection conn, Long id) throws SQLException {
        return 0;
    }

    @Override
    public List<Order> getOrderByUserId(Connection conn, Long userId) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Order> orderList = new ArrayList<>();
        if (null != conn){
            String sql = "select * from t_order where user_id = ? and is_deleted = 0";
            Object[] params = new Object[]{
                    userId
            };
            //查询
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            //
            while (rs.next()){
                Order _order = new Order();
                _order.setId(rs.getLong("id"));
                _order.setUserId(rs.getLong("user_id"));
                _order.setUserName(rs.getString("user_name"));
                _order.setNewspaperId(rs.getLong("newspaper_id"));
                _order.setNewspaperName(rs.getString("newspaper_name"));
                _order.setOrderNumber(rs.getString("order_number"));
                _order.setPeriod(rs.getInt("period"));
                _order.setSubscriptUnit(rs.getString("subscript_unit"));
                _order.setCount(rs.getInt("count"));
                _order.setTotalPrice(rs.getBigDecimal("total_price"));
                _order.setExpiryTime(rs.getDate("expiry_time"));
                _order.setRemark(rs.getString("remark"));
                _order.setCreateTime(rs.getDate("create_time"));
                orderList.add(_order);
            }
            //关闭资源
            BaseDao.closeResource(null,pstm,rs);
            System.out.println("OrderDao 查询订阅信息成功");
        }
        return orderList;
    }

    @Override
    public Order getOrderByOrderNumber(Connection conn, String orderNumber) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Order order = null;
        if (null != conn){
            String sql = "select * from t_order where order_number = ? and is_deleted = 0";
            Object[] params = new Object[]{
                    orderNumber
            };
            //查询
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            while (rs.next()){
                order = new Order();
                order.setId(rs.getLong("id"));
                order.setUserId(rs.getLong("user_id"));
                order.setUserName(rs.getString("user_name"));
                order.setNewspaperId(rs.getLong("newspaper_id"));
                order.setNewspaperName(rs.getString("newspaper_name"));
                order.setOrderNumber(rs.getString("order_number"));
                order.setPeriod(rs.getInt("period"));
                order.setSubscriptUnit(rs.getString("subscript_unit"));
                order.setCount(rs.getInt("count"));
                order.setTotalPrice(rs.getBigDecimal("total_price"));
                order.setExpiryTime(rs.getDate("expiry_time"));
                order.setRemark(rs.getString("remark"));
                order.setCreateTime(rs.getDate("create_time"));
            }
            //关闭资源
            BaseDao.closeResource(null,pstm,rs);
            System.out.println("OrderDao 查询订阅信息成功");
        }
        return order;
    }
}
