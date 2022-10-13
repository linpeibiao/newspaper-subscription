package com.zkxg.newspaper_subscription.user;

import java.util.List;
import java.util.Map;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.controller.UserController;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
import com.zkxg.newspaper_subscription.service.UserService;
import com.zkxg.newspaper_subscription.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author xiaohu
 * @date 2022/10/11/ 17:09
 * @description
 */
public class UserTests {
    private UserService userService;
    private UserController userController;
    public UserTests(){
        userService = new UserServiceImpl();
        userController = new UserController();
    }

    @Test
    public void getCurrentLoginUserTest(){
        // 先登录
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAccount("xiaohugege");
        loginInfo.setPhone("");
        loginInfo.setPassword("linxiaohu");
        // 首先要登陆
        userController.userLogin(loginInfo);
        System.out.println(userController.getCurrentLoginUser().getData());
    }

    @Test
    public void getUserByIdTest(){
        System.out.println(userController.getUserById(1L).getData());
    }

    @Test
    public void getUserPageTest(){
        // 先登录
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAccount("xiaohugege");
        loginInfo.setPhone("");
        loginInfo.setPassword("linxiaohu");
        // 首先要登陆
        userController.userLogin(loginInfo);
        List list = userController.getUserPage(1, 10).getData();
        System.out.println(list.size());
        System.out.println(list);
    }

    @Test
    public void deleteTest(){
        final BaseResponse<String> stringBaseResponse = userController.userDelete(-9L);
        System.out.println(stringBaseResponse.getData());
    }

    @Test
    public void updateTest(){
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAccount("linxiaohu");
        loginInfo.setPhone("linxiaohu");
        loginInfo.setPassword("linxiaohu");
        // 首先要登陆，才可以修改
        userController.userLogin(loginInfo);
        User user = new User();
        user.setId(2L);
        user.setRealName("linxiaohu");
        user.setNackname("linxiaohu");
        user.setAccount("linxiaohu");
        user.setRemark("linxiaohu is a handsome man!!!!!");
        final BaseResponse<String> stringBaseResponse = userController.userInfoUpdate(user);
        System.out.println(stringBaseResponse.getData());

    }

    @Test
    public void addTest(){
        User user = new User();
        user.setAccount("linxiaohu");
        user.setPassword("linxiaohu");
        user.setNackname("林小虎哥哥");
        user.setRealName("林小虎");
        final int add = userService.add(user);
        System.out.println(add);
    }

    @Test
    public void addBitchTest(){
        long start = System.currentTimeMillis();
        for (int i = 4; i < 1000; i++) {
            User user = new User();
            user.setPassword("linxiaohu");
            user.setNackname("林小虎哥哥");
            user.setRealName("林小虎");
            user.setAccount("linxiaohu" + i);
            userController.userRegister(user);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时" + (end - start));
    }

    @Test
    public void loginTest(){
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAccount("linxiaohu");
        loginInfo.setPhone("linxiaohu");
        loginInfo.setPassword("linxiaohu");
        LoginInfo loginInfo1 = new LoginInfo();
        loginInfo1.setAccount("linxioahu1");
        loginInfo1.setPhone("13111111111");
        loginInfo1.setPassword("linxiaohu");
        final BaseResponse<User> userBaseResponse = userController.userLogin(loginInfo);
        final BaseResponse<User> userBaseResponse1 = userController.userLogin(loginInfo1);
        final Map<String, User> stringUserMap = userController.tl.get();
        System.out.println(stringUserMap.size());// 1才是正确的
        System.out.println(userBaseResponse);
    }
    @Test
    public void loginTest2(){

        Thread t1 = new Thread(() -> {
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setAccount("linxiaohu");
            loginInfo.setPhone("linxiaohu");
            loginInfo.setPassword("linxiaohu");
            final BaseResponse<User> userBaseResponse = userController.userLogin(loginInfo);
            final Map<String, User> stringUserMap = userController.tl.get();
            System.out.println(Thread.currentThread().getName() + ": " + stringUserMap.get("linxiaohu"));
        }, "linxiaohu");

        Thread t2 = new Thread(() -> {
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setAccount("linxiaohu1");
            loginInfo.setPhone("linxiaohu");
            loginInfo.setPassword("linxiaohu");
            final BaseResponse<User> userBaseResponse = userController.userLogin(loginInfo);
            final Map<String, User> stringUserMap = userController.tl.get();
            System.out.println(Thread.currentThread().getName() + ": " + stringUserMap.get("linxiaohu1"));
        }, "linxiaohu1");

        t1.start();
        t2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
