package com.zkxg.newspaper_subscription.service;

import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
import com.zkxg.newspaper_subscription.model.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author xiaohu
 * @date 2022/10/10/ 22:27
 * @description
 */
public interface UserService {
    // 获取用户列表
    List<User> getUserPage(int pageNum, int pageSize);
    // 用户登录
    Map<String, User> login(LoginInfo loginInfo);
    // 判断用户账号是否存在
    boolean checkAccountExist(String account);
    // 增
    int add(User user);
    // 删
    // 根据id
    int delete(Long id);
    // 改
    // 根据id
    int update(User user);
    // 查
    // 根据id
    User getUser(Long id);
}
