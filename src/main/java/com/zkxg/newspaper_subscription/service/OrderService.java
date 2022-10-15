package com.zkxg.newspaper_subscription.service;

import com.zkxg.newspaper_subscription.model.dto.OrderDto;
import com.zkxg.newspaper_subscription.model.entity.Order;

import java.util.List;

/**
 * @author xiaohu
 * @date 2022/10/15/ 15:05
 * @description 订阅报刊业务逻辑接口
 */
public interface OrderService {
    // 用户订阅报刊
    Order orderNewspaper(OrderDto orderDto);
    // 用户查看自己的订阅
    List<Order> getOrderByUserId(Long id);
}
