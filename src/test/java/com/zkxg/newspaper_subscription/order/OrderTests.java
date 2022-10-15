package com.zkxg.newspaper_subscription.order;
import java.math.BigDecimal;

import com.zkxg.newspaper_subscription.controller.OrderController;
import com.zkxg.newspaper_subscription.controller.UserController;
import com.zkxg.newspaper_subscription.model.dto.OrderDto;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
import org.junit.Test;

/**
 * @author xiaohu
 * @date 2022/10/15/ 16:40
 * @description 订单测试类
 */
public class OrderTests {
    private UserController userController;
    private OrderController orderController;
    public OrderTests(){
        userController = new UserController();
        orderController = new OrderController();
    }

    public void userLogin(){
        // 先登录
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAccount("linxiaohu2");
        loginInfo.setPhone("");
        loginInfo.setPassword("linxiaohu");
        // 首先要登陆
        userController.userLogin(loginInfo).getData();
    }

    @Test
    public void getOrderByUserIdTest(){
        userLogin();
        System.out.println(orderController.getOrderByUserId(7L));
    }

    @Test
    public void orderNewsTest(){
        userLogin();
        OrderDto orderDto = new OrderDto();
        orderDto.setUserId(7L);
        orderDto.setNewspaperId(112L);
        orderDto.setPeriod(12);
        orderDto.setCount(2);
        orderDto.setSinglePrice(new BigDecimal("120"));
        orderDto.setTotalPrice(new BigDecimal("2880"));
        orderDto.setRemark("花花公子，yyds");
        System.out.println(orderController.orderNewspaper(orderDto));
    }
}
