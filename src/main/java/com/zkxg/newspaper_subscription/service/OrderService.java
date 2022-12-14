package com.zkxg.newspaper_subscription.service;

import com.zkxg.newspaper_subscription.model.dto.OrderDto;
import com.zkxg.newspaper_subscription.model.entity.Order;
import com.zkxg.newspaper_subscription.model.vo.NewspaperInfo;
import com.zkxg.newspaper_subscription.model.vo.UserCostInfo;
import com.zkxg.newspaper_subscription.model.vo.UserInfo;

import java.util.Date;
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
    // 通过id删除订单
    int deleteOrder(Long id);
    // 通过订单号获取订单详情
    Order getOrderByOrderNumber(String orderNumber);
    // 通过报刊id统计报刊被订阅的订单数
    int getCountByNewspaperId(Long newspaperId);
    // 获取花钱 前n多的用户
    List<UserInfo> getCostMostUser(int n);
    // 获取下订单数量前n多的用户
    List<UserInfo> getOrderMostUser(int n);
    // 按照阶段内欢迎程度获取报刊信息
    List<NewspaperInfo> getPopularNewspaper(Date start, Date end, int n);
    // 获取最受欢迎的杂志类型
    List<String> getMostPopularNewspaperType();
    // 获取用户在报刊上的花费信息
    UserCostInfo getUserCostInfoByUserId(Long userId);
}
