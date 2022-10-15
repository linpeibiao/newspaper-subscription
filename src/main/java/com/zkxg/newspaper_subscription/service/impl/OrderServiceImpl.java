package com.zkxg.newspaper_subscription.service.impl;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.dao.BaseDao;
import com.zkxg.newspaper_subscription.dao.OrderDao;
import com.zkxg.newspaper_subscription.dao.impl.OrderDaoImpl;
import com.zkxg.newspaper_subscription.exception.BusinessException;
import com.zkxg.newspaper_subscription.model.dto.OrderDto;
import com.zkxg.newspaper_subscription.model.entity.Order;
import com.zkxg.newspaper_subscription.service.OrderService;
import com.zkxg.newspaper_subscription.util.SnowFlakeGenerateWorker;

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
}
