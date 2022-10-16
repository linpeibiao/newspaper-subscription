package com.zkxg.newspaper_subscription.controller;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.common.ResultUtils;
import com.zkxg.newspaper_subscription.exception.BusinessException;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
import com.zkxg.newspaper_subscription.service.UserService;
import com.zkxg.newspaper_subscription.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xiaohu
 * @date 2022/10/10/ 22:26
 * @description 用户业务服务接口
 */
public class UserController {
    //
    private UserService userService;
    // 用于保存用户登录态
    public static ThreadLocal<Map<String, User>> tl = new ThreadLocal<>();;
    public UserController(){
        userService = new UserServiceImpl();
    }

    /**
     * 用户退出登录
     * @return
     */
    public BaseResponse<String> logout(){
        // 直接将ThreadLocal的值remove 即可
        tl.remove();
        return ResultUtils.success("退出登陆成功");
    }

    /**
     * 获取当前登录用户
     * @return
     */
    public BaseResponse<User> getCurrentLoginUser(){
        User user = null;
        Map<String, User> userMap = this.tl.get();
        if (userMap == null){
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        Set<Map.Entry<String, User>> userEntrySet = userMap.entrySet();
        for (Map.Entry<String, User> userEntry : userEntrySet) {
            // 只获取当前用户
            user = userEntry.getValue();
            break;
        }
        if (userEntrySet.isEmpty() || user == null){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        return ResultUtils.success(user);
    }


    /**
     * 获取用户列表。只能是管理员才可以获取
     * @param pageNum
     * @param pageSize
     * @return
     */
    public BaseResponse<List<User>> getUserPage(Integer pageNum, Integer pageSize){
        // 从第1页开始获取
        if (pageNum <= 0 || pageSize <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 未登录且不是管理员不能获取用户列表
        User user = null;
        user = this.getCurrentLoginUser().getData();
        if (user == null || user.getRole() != 1){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }

        // 数据库是从0开始获取数据的，所以pageNum 要减1
        pageNum -= 1;
        final List<User> userPage = userService.getUserPage(pageNum, pageSize);
        return ResultUtils.success(userPage);
    }

    /**
     * 通过id获取用户信息
     * @param id
     * @return
     */
    public BaseResponse<User> getUserById(Long id){
        if (id <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        final User user = userService.getUser(id);
        return ResultUtils.success(user);
    }

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    public BaseResponse<String> userDelete(Long id){
        if (id == null || id <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        final int delete = userService.delete(id);
        String res = delete > 0 ? "注销成功" : "注销失败";
        return ResultUtils.success(res);
    }

    /**
     * 用户修改个人信息
     * @param user
     * @return
     */
    public BaseResponse<String> userInfoUpdate(User user){
        // 判空
        if (user == null){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        String account = user.getAccount();
        if (account == null){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        // 登录态判断
        if (!authUserCheck(account)){
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        int update = userService.update(user);
        String res = update > 0 ? "修改成功" : "修改失败";
        return ResultUtils.success(res);
    }
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
            return ResultUtils.error(ErrorCode.PARAMS_ERROR,"没有该账户");
        }
        tl.set(login);
        //
        return ResultUtils.success(login.get(loginInfo.getAccount()));
    }

    /**
     * 通过账号认证登录态
     * @param account
     * @return
     */
    public boolean authUserCheck(String account){
        // 判断登录状态
        Map<String, User> loginUserMap = this.tl.get();
        // 没有用户登录，直接返回未登录
        if (loginUserMap == null || loginUserMap.size() <= 0){
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        User loginUser = loginUserMap.get(account);
        // 未登录
        if (loginUser == null){
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        return true;
    }
}
