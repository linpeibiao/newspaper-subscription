package com.zkxg.newspaper_subscription.controller;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.common.ResultUtils;
import com.zkxg.newspaper_subscription.exception.BusinessException;
import com.zkxg.newspaper_subscription.model.dto.OrderDto;
import com.zkxg.newspaper_subscription.model.entity.Order;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.service.OrderService;
import com.zkxg.newspaper_subscription.service.impl.OrderServiceImpl;

import java.util.List;

/**
 * @author xiaohu
 * @date 2022/10/15/ 15:03
 * @description 订阅业务接口
 */
public class OrderController {
    // 引入service层
    private OrderService orderService;
    // 引入报刊业务层接口
    private NewspaperController newspaperController;
    // 引入用户业务层接口
    private UserController userController;
    public OrderController(){
        orderService = new OrderServiceImpl();
        newspaperController = new NewspaperController();
        userController = new UserController();
    }

    /**
     * 通过用户id获取订单
     * @param id
     * @return
     */
    public BaseResponse<List<Order>> getOrderByUserId(Long userId){
        if (userId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 判断登录
        User user = userController.getCurrentLoginUser().getData();
        if (user == null || !user.getId().equals(userId)){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        List<Order> orderList = orderService.getOrderByUserId(userId);
        return ResultUtils.success(orderList);
    }

    /**
     * 用户订阅报刊
     * @param orderDto
     * @return
     */
    public BaseResponse<Order> orderNewspaper(OrderDto orderDto){
        // 判空
        if (orderDto == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 判断是否登录，同时如果是管理员，不能订阅
        if (newspaperController.isAdmin()) {
            throw new BusinessException(ErrorCode.NO_AUTH, "管理员不能订阅报刊");
        }

        Order order = orderService.orderNewspaper(orderDto);
        return ResultUtils.success(order);

    }
}
