package com.zkxg.newspaper_subscription.user;
import java.util.Date;

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
    public void loginTest(){
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAccount("linxiaohu");
        loginInfo.setPhone("linxiaohu");
        loginInfo.setPassword("linxiaohu");
        final BaseResponse<User> userBaseResponse = userController.userLogin(loginInfo);
        System.out.println(userBaseResponse);
    }
}
