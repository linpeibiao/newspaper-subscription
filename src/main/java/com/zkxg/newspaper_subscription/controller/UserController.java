package com.zkxg.newspaper_subscription.controller;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.common.ResultUtils;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
import com.zkxg.newspaper_subscription.service.UserService;
import com.zkxg.newspaper_subscription.service.impl.UserServiceImpl;
import java.util.Map;

/**
 * @author xiaohu
 * @date 2022/10/10/ 22:26
 * @description 用户业务服务接口
 */
public class UserController {
    //
    private UserService userService;
    public UserController(){
        userService = new UserServiceImpl();
    }
    // 用于保存用户登录态
    private ThreadLocal<Map<String, User>> tl = new ThreadLocal<>();

    /**
     * 用户注册
     * @param user
     * @return
     */
    public BaseResponse<String> userRegister(User user){
        if (user == null){
            return ResultUtils.error(ErrorCode.NULL_ERROR);
        }
        final int add = userService.add(user);
        return add > 0 ? ResultUtils.success("注册成功") : ResultUtils.error(null, null, "注册失败");
    }

    /**
     * 用户登录
     * @param loginInfo
     * @return
     */
    public BaseResponse<User> userLogin(LoginInfo loginInfo){
        if (loginInfo == null){
            return ResultUtils.error(ErrorCode.NULL_ERROR);
        }
        Map<String, User> login = userService.login(loginInfo);
        if (login == null){
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        tl.set(login);
        //
        return ResultUtils.success(login.get(loginInfo.getPassword()));
    }
}
