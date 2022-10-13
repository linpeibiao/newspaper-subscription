package com.zkxg.newspaper_subscription.controller;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.common.ResultUtils;
import com.zkxg.newspaper_subscription.exception.BusinessException;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.service.NewspaperService;
import com.zkxg.newspaper_subscription.service.impl.NewspaperServiceImpl;

import javax.xml.transform.Result;

/**
 * @author xiaohu
 * @date 2022/10/13/ 21:26
 * @description 报刊业务控制层接口
 */
public class NewspaperController {
    // 引入service层
    private NewspaperService newspaperService;
    // 引入用户层接口
    private UserController userController;

    public NewspaperController(){
        newspaperService = new NewspaperServiceImpl();
        userController = new UserController();
    }

    /**
     * 添加报刊信息
     * @param newspaper
     * @return
     */
    public BaseResponse<String> add(Newspaper newspaper){
        // 判空
        if (newspaper == null){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        // 只能是管理员才可以添加报刊
        // 获取当前登录用户，判断是否为管理员
        User user = userController.getCurrentLoginUser().getData();
        if (user == null || user.getState() != 1){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }

        int add = newspaperService.add(newspaper);
        return add > 0 ? ResultUtils.success("添加成功") : ResultUtils.success("添加失败");
    }
}
