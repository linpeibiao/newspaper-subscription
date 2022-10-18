package com.zkxg.newspaper_subscription.service.impl;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.dao.BaseDao;
import com.zkxg.newspaper_subscription.dao.OrderDao;
import com.zkxg.newspaper_subscription.dao.impl.OrderDaoImpl;
import com.zkxg.newspaper_subscription.exception.BusinessException;
import com.zkxg.newspaper_subscription.model.dto.OrderDto;
import com.zkxg.newspaper_subscription.model.entity.Order;
import com.zkxg.newspaper_subscription.model.vo.NewspaperInfo;
import com.zkxg.newspaper_subscription.model.vo.UserCostInfo;
import com.zkxg.newspaper_subscription.model.vo.UserInfo;
import com.zkxg.newspaper_subscription.service.OrderService;
import com.zkxg.newspaper_subscription.util.SnowFlakeGenerateWorker;
import org.apache.commons.lang3.StringUtils;

/**
 * @author xiaohu
 * @date 2022/10/15/ 15:06
 * @description 订阅报刊逻辑接口实现类
 */
public class OrderServiceImpl implements OrderService {
    // 引入订单dao层
    private OrderDao orderDao;
    // 引入雪花算法订单号生成工具
    private SnowFlakeGenerateWorker snowFlakeGenerateWorker;
    public OrderServiceImpl(){
        orderDao = new OrderDaoImpl();
        snowFlakeGenerateWorker = new SnowFlakeGenerateWorker(0L,0L);
    }

    @Override
    public int getCountByNewspaperId(Long newspaperId){
        int count = 0;
        Connection conn = null;
        try{
            conn = BaseDao.getConnection();
            count = orderDao.getCountByNewspaperId(conn, newspaperId);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }finally {
            BaseDao.closeResource(conn, null, null);
        }
        return count;
    }

    @Override
    public List<UserInfo> getCostMostUser(int n) {
        Connection conn = null;
        List<UserInfo> userList = null;
        try{
            conn = BaseDao.getConnection();
            userList = orderDao.getCostMostUser(conn, n);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(conn, null, null);
        }
        return userList;
    }

    @Override
    public List<UserInfo> getOrderMostUser(int n) {
        Connection conn = null;
        List<UserInfo> userList = null;
        try{
            conn = BaseDao.getConnection();
            userList = orderDao.getOrderMostUser(conn, n);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(conn, null, null);
        }
        return userList;
    }

    @Override
    public List<NewspaperInfo> getPopularNewspaper(Date start, Date end, int n) {
        // 分别对应四种情况来设置date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (start == null){
            try {
                start = simpleDateFormat.parse("1970-01-01 00:00:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (end == null){
            end = new Date();
        }
        String startTime = simpleDateFormat.format(start);
        String endTime = simpleDateFormat.format(end);
        Connection conn = null;
        List<NewspaperInfo> newspaperList = null;
        try{
            conn = BaseDao.getConnection();
            newspaperList = orderDao.getPopularNewspaper(conn, startTime, endTime, n);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(conn, null, null);
        }
        return newspaperList;
    }

    @Override
    public List<String> getMostPopularNewspaperType() {
        Connection conn = null;
        List<String> typeList = null;
        try{
            conn = BaseDao.getConnection();
            typeList = orderDao.getMostPopularType(conn);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(conn, null, null);
        }
        return typeList;
    }

    @Override
    public UserCostInfo getUserCostInfoByUserId(Long userId) {
        Connection conn = null;
        UserCostInfo userCostInfo = null;
        try{
            conn = BaseDao.getConnection();
            userCostInfo = orderDao.getUserCostInfoByUserId(conn, userId);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(conn, null, null);
        }
        return userCostInfo;
    }

    @Override
    public Order orderNewspaper(OrderDto orderDto) {
        // 判空
        Long userId = orderDto.getUserId();
        Long newspaperId = orderDto.getNewspaperId();
        if (userId == null || userId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户id格式错误");
        }
        if (newspaperId == null || newspaperId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "报刊id格式错误");
        }
        String userName = orderDto.getUserName();
        String newspaperName = orderDto.getNewspaperName();
        if (StringUtils.isAnyEmpty(userName, newspaperName)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户或报刊名称不能为空");
        }

        // 判断订阅数量和期数
        int count = orderDto.getCount();
        int period = orderDto.getPeriod();
        if (count < 1 || period < 1){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "订阅数量或订阅期数不能小于1");
        }
        // TODO 获取报刊的单价,检查总价格是否正确
        // 计算订阅总价格在界面计算好就行了
        BigDecimal singlePrice = orderDto.getSinglePrice();
        BigDecimal totalPrice = orderDto.getTotalPrice();
        if (singlePrice == null || totalPrice == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "价格信息不能为空");
        }

        // 生成订单号
        String orderNumber = snowFlakeGenerateWorker.generateNextId();
        // 生成订单
        Order order = null;
        Connection conn = null;
        try{
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);
            order = new Order();
            order.setOrderNumber(orderNumber);
            order.setUserId(userId);
            order.setUserName(userName);
            order.setNewspaperName(newspaperName);
            order.setNewspaperId(newspaperId);
            order.setPeriod(period);
            order.setCount(count);
            order.setTotalPrice(totalPrice);
            order.setRemark(orderDto.getRemark());
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
            order.setDeleted(0);
            int add = orderDao.add(conn, order);
            conn.commit();
            if (add <= 0){
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }
        }catch (Exception e){
            System.out.println("OrderService订阅报刊失败");
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            BaseDao.closeResource(conn, null, null);
        }
        return order;
    }

    @Override
    public List<Order> getOrderByUserId(Long userId) {
        List<Order> orderList = null;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            // TODO 给订单表用户id创建索引
            orderList = orderDao.getOrderByUserId(conn, userId);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(conn, null, null);
        }
        return orderList;
    }

    @Override
    public int deleteOrder(Long id) {
        Connection conn = null;
        int delete = 0;
        try{
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);
            delete = orderDao.delete(conn, id);
            conn.commit();
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
        return delete;
    }

    @Override
    public Order getOrderByOrderNumber(String orderNumber) {
        Connection conn = null;
        Order order= null;
        try{
            conn = BaseDao.getConnection();
            order = orderDao.getOrderByOrderNumber(conn, orderNumber);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn, null, null);
        }
        return order;
    }
}
