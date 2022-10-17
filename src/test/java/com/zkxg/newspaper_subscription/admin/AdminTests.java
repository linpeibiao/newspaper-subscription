package com.zkxg.newspaper_subscription.admin;

import com.zkxg.newspaper_subscription.controller.AdminController;
import com.zkxg.newspaper_subscription.controller.UserController;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaohu
 * @date 2022/10/17/ 10:10
 * @description 管理员接口测试类
 */
public class AdminTests {
    private AdminController adminController;
    private UserController userController;
    public AdminTests(){
        adminController = new AdminController();
        userController = new UserController();
    }
    public void userLogin(){
        // 先登录
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAccount("linxiaohu");
        loginInfo.setPhone("");
        loginInfo.setPassword("linxiaohu");
        // 首先要登陆
        userController.userLogin(loginInfo).getData();
    }

    @Test
    public void getMostPopularNewspaperTypeTest(){
        userLogin();
        System.out.println(adminController.getMostPopularNewspaperType().getData());
    }

    @Test
    public void getPopularNewspaperTest() throws ParseException {
        userLogin();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = simpleDateFormat.parse("2022-10-15 00:00:00");
        Date end = simpleDateFormat.parse("2022-10-17 00:00:00");
        System.out.println(adminController.getPopularNewspaper(start, end, 0).getData());
    }

    @Test
    public void getOrderMostUserTest(){
        userLogin();
        System.out.println(adminController.getOrderMostUser(2).getData());
    }

    @Test
    public void getCostMostUserTest(){
        userLogin();
        System.out.println(adminController.getCostMostUser(10).getData());
    }

    @Test
    public void getCountByNewspaperId(){
        userLogin();
        int count = adminController.getCountByNewspaperId(112L).getData();
        System.out.println(count);
    }
}
