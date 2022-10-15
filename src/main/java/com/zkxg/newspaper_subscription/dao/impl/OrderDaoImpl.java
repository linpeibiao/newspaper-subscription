package com.zkxg.newspaper_subscription.dao.impl;

import com.zkxg.newspaper_subscription.dao.BaseDao;
import com.zkxg.newspaper_subscription.dao.OrderDao;
import com.zkxg.newspaper_subscription.model.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

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
            String sql = "insert into t_order (order_number,user_id,newspaper_id," +
                    "period,subscript_unit,count,total_price,expiry_time,remark,is_deleted," +
                    "create_time,update_time) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            Object params[] = new Object[]{
                    order.getOrderNumber(),
                    order.getUserId(),
                    order.getNewspaperId(),
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
        return 0;
    }

    @Override
    public int update(Connection conn, Long id) throws SQLException {
        return 0;
    }

    @Override
    public Order getOrder(Connection conn, Long id) throws SQLException {
        return null;
    }

    @Override
    public Order getOrderByOrderNumber(Connection conn, String orderNumber) throws SQLException {
        return null;
    }
}
