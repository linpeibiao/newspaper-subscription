package com.zkxg.newspaper_subscription.dao;

import com.zkxg.newspaper_subscription.model.entity.Order;
import com.zkxg.newspaper_subscription.model.entity.User;

/**
 * @author xiaohu
 * @date 2022/10/11/ 10:58
 * @description 订单dao层接口
 */
public interface OrderDao {
    // 增
    int add(Order order);
    // 删
    // 根据id
    int delete(Long id);
    // 改
    // 根据id
    int update(Long id);
    // 查
    // 根据id
    Order getOrder(Long id);
}
