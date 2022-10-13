package com.zkxg.newspaper_subscription.controller;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.common.ResultUtils;
import com.zkxg.newspaper_subscription.exception.BusinessException;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.service.NewspaperService;
import com.zkxg.newspaper_subscription.service.impl.NewspaperServiceImpl;


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
     * 通过id删除报刊信息
     * @param id
     * @return
     */
    public BaseResponse<String> deleteNewsPaper(Long id){
        // 判空、是否合法
        if (id == null || id <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 只能是管理员才可以删除
        if (!isAdmin()){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        int delete = newspaperService.delete(id);
        return delete > 0 ? ResultUtils.success("删除成功") : ResultUtils.success("删除失败");

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
        if (!isAdmin()){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }

        int add = newspaperService.add(newspaper);
        return add > 0 ? ResultUtils.success("添加成功") : ResultUtils.success("添加失败");
    }

    /**
     * 判断当前用户是否为管理员
     * @return
     */
    public boolean isAdmin(){
        User user = userController.getCurrentLoginUser().getData();
        if (user == null){
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        return user.getState() == 1;
    }
}
