package com.zkxg.newspaper_subscription.controller;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.common.ResultUtils;
import com.zkxg.newspaper_subscription.exception.BusinessException;
import com.zkxg.newspaper_subscription.model.vo.UserCostInfo;
import com.zkxg.newspaper_subscription.service.OrderService;
import com.zkxg.newspaper_subscription.service.impl.OrderServiceImpl;

import java.util.List;

/**
 * @author xiaohu
 * @date 2022/10/17/ 9:04
 * @description 管理员业务请求接口
 * 该接口的请求都需要管理员身份认证
 */
public class AdminController {
    private OrderService orderService;
    private NewspaperController newspaperController;
    public AdminController(){
        orderService = new OrderServiceImpl();
        newspaperController = new NewspaperController();
    }

    /**
     * 获取花钱 前n多的用户
     * @return
     */
    public BaseResponse<List<UserCostInfo>> getCostMostUser(int n){
        if (n <= 0){
            n = 10; // 默认取前十
        }
        // 判权
        if (!newspaperController.isAdmin()){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        List<UserCostInfo> userList = orderService.getCostMostUser(n);
        return ResultUtils.success(userList);
    }

    /**
     * 通过报刊id获取该报刊被订阅的总数量
     * @param newspaperId
     * @return
     */
    public BaseResponse<Integer> getCountByNewspaperId(Long newspaperId){
        if (newspaperId == null || newspaperId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 判权，只能管理员能统计
        if (!newspaperController.isAdmin()){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        int count = orderService.getCountByNewspaperId(newspaperId);
        return ResultUtils.success(count);
    }
}
