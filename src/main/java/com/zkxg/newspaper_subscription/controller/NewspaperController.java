package com.zkxg.newspaper_subscription.controller;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.common.ResultUtils;
import com.zkxg.newspaper_subscription.exception.BusinessException;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.service.NewspaperService;
import com.zkxg.newspaper_subscription.service.impl.NewspaperServiceImpl;

import java.util.List;


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
     * 按照类型查询
     * @param type
     * @return
     */
    public BaseResponse<List<Newspaper>> getNewspaperByType(String type){
        // 默认返回前十条信息
        if (type == null){
            return getNewspaperPage(1, 10);
        }
        final List<Newspaper> newspaperList = newspaperService.getNewspaperByType(type);
        return ResultUtils.success(newspaperList);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public BaseResponse<List<Newspaper>> getNewspaperPage(Integer pageNum, Integer pageSize){
        // 从第1页开始获取
        if (pageNum <= 0 || pageSize <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        final List<Newspaper> newspaperPage = newspaperService.getNewspaperPage(pageNum, pageSize);
        return ResultUtils.success(newspaperPage);
    }

    /**
     * 通过名称模糊查询
     * @param name
     * @return
     */
    public BaseResponse<List<Newspaper>> getNewspaperByName(String name){
        // 空默认前十条
        if (name == null){
            return getNewspaperPage(1, 10);
        }
        final List<Newspaper> newspaperList = newspaperService.getNewspaperByName(name);
        return ResultUtils.success(newspaperList);
    }

    /**
     * 通过id获取报刊信息
     * @param id
     * @return
     */
    public BaseResponse<Newspaper> getNewspaperById(Long id){
        if (id <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        final Newspaper newspaper = newspaperService.getUserById(id);
        return ResultUtils.success(newspaper);
    }

    /**
     * 修改报刊信息
     * @param newspaper
     * @return
     */
    public BaseResponse<String> updateNewspaper(Newspaper newspaper){
        // 判空
        if (newspaper == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }

        // 判权
        if (!isAdmin()){
            throw new BusinessException(ErrorCode.NO_AUTH);
        }

        int update = newspaperService.update(newspaper);
        return update > 0 ? ResultUtils.success("修改成功") : ResultUtils.success("修改失败");

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
        return user.getRole() == 1;
    }
}
