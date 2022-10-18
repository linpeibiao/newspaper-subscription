package com.zkxg.newspaper_subscription.dao.impl;

import com.zkxg.newspaper_subscription.dao.BaseDao;
import com.zkxg.newspaper_subscription.dao.OrderDao;
import com.zkxg.newspaper_subscription.model.entity.Order;
import com.zkxg.newspaper_subscription.model.vo.NewspaperInfo;
import com.zkxg.newspaper_subscription.model.vo.UserCostInfo;
import com.zkxg.newspaper_subscription.model.vo.UserInfo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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

    @Override
    public int getCountByNewspaperId(Connection conn, Long newspaperId) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;
        if (conn != null) {
            //
            String sql = "select sum(count) as count from t_order where newspaper_id = ? and is_deleted=0";
            Object params[] = new Object[]{
                    newspaperId
            };
            //执行sql语句
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            while (rs.next()){
                count = rs.getInt("count");
            }
            //关闭资源
            BaseDao.closeResource(null, pstm, null);
            System.out.println("OrderDao 查询统计信息成功");
        }
        return count;
    }

    @Override
    public List<UserInfo> getCostMostUser(Connection conn, int n) throws SQLException{
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<UserInfo> userList = null;
        if (conn != null){
            userList = new ArrayList<>();
            String sql = "select u.*, cost.total_cost from t_user as u," +
                    " (select user_id, sum(total_price) as total_cost from t_order " +
                    "where is_deleted = 0 group by user_id ORDER BY total_cost desc limit 0,?) " +
                    "as cost " +
                    "where cost.user_id = u.id;";
            Object[] params = new Object[]{n};
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            // 返回的信息一定要脱敏
            while(rs.next()){
                UserInfo _user = new UserInfo();
                _user.setUserId(rs.getLong("id"));
                _user.setAccount(rs.getString("account"));
                _user.setNackname(rs.getString("nackname"));
                _user.setAvatar(rs.getString("avatar"));
                _user.setTotalCost(rs.getBigDecimal("total_cost"));
                userList.add(_user);
            }
            System.out.println("统计用户消费信息成功");
        }
        BaseDao.closeResource(null,pstm,rs);
        return userList;
    }

    @Override
    public List<UserInfo> getOrderMostUser(Connection conn, int n) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<UserInfo> userList = null;
        if (conn != null){
            userList = new ArrayList<>();
            String sql = "SELECT " +
                    "u.*," +
                    "order_quantity.total_order_quantity " +
                    "FROM " +
                    "t_user AS u," +
                    "( SELECT user_id, count( * ) AS total_order_quantity FROM t_order " +
                    "WHERE is_deleted = 0 " +
                    "GROUP BY user_id " +
                    "ORDER BY total_order_quantity DESC LIMIT 0, ? ) AS order_quantity " +
                    "WHERE " +
                    "order_quantity.user_id = u.id";
            Object[] params = new Object[]{n};
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            // 返回的信息一定要脱敏
            while(rs.next()){
                UserInfo _user = new UserInfo();
                _user.setUserId(rs.getLong("id"));
                _user.setAccount(rs.getString("account"));
                _user.setNackname(rs.getString("nackname"));
                _user.setAvatar(rs.getString("avatar"));
                _user.setOrderQuantity(rs.getInt("total_order_quantity"));
                userList.add(_user);
            }
            System.out.println("统计用户消费信息成功");
        }
        BaseDao.closeResource(null,pstm,rs);
        return userList;
    }

    @Override
    public List<NewspaperInfo> getPopularNewspaper(Connection conn, String start, String end, int n) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<NewspaperInfo> newspaperList = null;
        if (conn != null){
            newspaperList = new ArrayList<>();
            String sql = "SELECT " +
                    "n.*," +
                    "oq.order_quantity " +
                    "FROM " +
                    "t_newspaper AS n," +
                    "(" +
                    "SELECT DISTINCT " +
                    "newspaper_id," +
                    "count(*) AS order_quantity " +
                    "FROM " +
                    "t_order " +
                    "WHERE " +
                    "is_deleted = 0 " +
                    "and create_time >= ? and create_time <= ? " +
                    "GROUP BY " +
                    "newspaper_id " +
                    "ORDER BY " +
                    "order_quantity DESC " +
                    "LIMIT 1,?" +
                    ") AS oq " +
                    "WHERE " +
                    "n.id = oq.newspaper_id;";
            Object[] params = new Object[]{
                    start,
                    end,
                    n
            };
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            // 返回的信息一定要脱敏
            while(rs.next()){
                NewspaperInfo _newspaperInfo = new NewspaperInfo();
                _newspaperInfo.setNewspaperId(rs.getLong("id"));
                _newspaperInfo.setNewspaperName(rs.getString("name"));
                _newspaperInfo.setCover(rs.getString("cover"));
                _newspaperInfo.setType(rs.getString("type"));
                _newspaperInfo.setPublisher(rs.getString("publisher"));
                _newspaperInfo.setOrderQuantity(rs.getInt("order_quantity"));
                newspaperList.add(_newspaperInfo);
            }
            System.out.println("统计报刊订阅信息成功");
        }
        BaseDao.closeResource(null,pstm,rs);
        return newspaperList;
    }

    // TODO
    @Override
    public List<String> getMostPopularType(Connection conn) throws SQLException {
        List<String> list = new ArrayList<>();
        list.add("色情");
        return list;
    }

    @Override
    public UserCostInfo getUserCostInfoByUserId(Connection conn, Long userId) throws SQLException {
        // 1、通过用户id获取到用户的所有订单 getOrderByUserId()
        // select * from t_order where user_id = ? and is_deleted = 0
        // 2、拿到订单的花费金额，累加
        // 3、拿到报刊的id,通过报刊id获取类型，按照类型给报刊id分类，再累加各自的花费金额
        // select newspaper_id from t_newspaper group by type;
        // select sum(total_price) as newspaper_id_cost from t_order group by newspaper_id;
        // select sum(newspaper_id_cost) from t_temp where newspaper_id in (第311行)
        PreparedStatement pstm = null;
        ResultSet rs = null;
        UserCostInfo userCostInfo = null;
        BigDecimal sum = null;
        Map<String, BigDecimal> userCostInfoMap = null;
        if (conn != null) {
            userCostInfo = new UserCostInfo();
            userCostInfoMap = new HashMap<>();
            sum = new BigDecimal(0);
            String sql = "SELECT " +
                    "sum( o.total_price ) AS total_cost," +
                    "n.type " +
                    "FROM " +
                    "t_order AS o," +
                    "t_newspaper AS n " +
                    "WHERE " +
                    "o.is_deleted = 0 " +
                    "AND o.user_id = ? " +
                    "AND o.newspaper_id = n.id " +
                    "GROUP BY " +
                    "type";
            Object[] params = new Object[]{
                    userId
            };
            rs = BaseDao.execute(conn, pstm, rs,sql, params);
            while(rs.next()){
                String type = rs.getString("type");
                BigDecimal totalCost = rs.getBigDecimal("total_cost");
                sum = sum.add(totalCost);
                userCostInfoMap.put(type,totalCost);
            }
            userCostInfo.setUserId(userId);
            userCostInfo.setTotalCost(sum);
            userCostInfo.setTypePercentage(userCostInfoMap);
        }

        return userCostInfo;
    }
}
