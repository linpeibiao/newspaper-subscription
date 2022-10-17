package com.zkxg.newspaper_subscription.controller;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.common.ResultUtils;
import com.zkxg.newspaper_subscription.exception.BusinessException;
import com.zkxg.newspaper_subscription.model.vo.NewspaperInfo;
import com.zkxg.newspaper_subscription.model.vo.UserInfo;
import com.zkxg.newspaper_subscription.service.OrderService;
import com.zkxg.newspaper_subscription.service.impl.OrderServiceImpl;

import java.util.Date;
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
     * 获取最受欢迎的报刊类型
     * @return
     */
    public BaseResponse<List<String>> getMostPopularNewspaperType(){
        // 判权
        if (!newspaperController.isAdmin()){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        List<String> typeList = orderService.getMostPopularNewspaperType();
        return ResultUtils.success(typeList);
    }

    /**
     * 获取报刊信息按照某阶段内受欢迎程度
     * @param start
     * @param end
     * @return
     */
    public BaseResponse<List<NewspaperInfo>> getPopularNewspaper(Date start, Date end, int n){
        // 不判空了
        if (n <= 0){
            n = 10; // 默认取前十条
        }
        // 判权
        if (!newspaperController.isAdmin()){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        List<NewspaperInfo> newspaperList = orderService.getPopularNewspaper(start, end, n);
        return ResultUtils.success(newspaperList);
    }

    /**
     * 获取下订单前n多的用户
     * @param n
     * @return
     */
    public BaseResponse<List<UserInfo>> getOrderMostUser(int n){
        if (n <= 0){
            n = 10; // 默认取前十条
        }
        if (!newspaperController.isAdmin()){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        List<UserInfo> userList = orderService.getOrderMostUser(n);
        return ResultUtils.success(userList);
    }

    /**
     * 获取花钱 前n多的用户
     * @return
     */
    public BaseResponse<List<UserInfo>> getCostMostUser(int n){
        if (n <= 0){
            n = 10; // 默认取前十
        }
        // 判权
        if (!newspaperController.isAdmin()){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        List<UserInfo> userList = orderService.getCostMostUser(n);
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
