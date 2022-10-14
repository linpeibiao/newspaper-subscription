package com.zkxg.newspaper_subscription.service;

import com.zkxg.newspaper_subscription.model.entity.Newspaper;

import java.util.List;

/**
 * @author xiaohu
 * @date 2022/10/13/ 21:27
 * @description 报刊业务逻辑接口
 */
public interface NewspaperService {
    // 添加报刊
    int add(Newspaper newspaper);
    // 删除报刊
    int delete(Long id);
    // 修改报刊信息
    int update(Newspaper newspaper);
    // 通过id获取报刊信息
    Newspaper getUserById(Long id);
    // 通过名称模糊查询
    List<Newspaper> getNewspaperByName(String name);
    // 通过类型获取
    List<Newspaper> getNewspaperByType(String type);
    // 获取所有报刊
    List<Newspaper> getNewspaperPage(int pageNum, int pageSize);
}
