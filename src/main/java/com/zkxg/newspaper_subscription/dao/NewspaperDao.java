package com.zkxg.newspaper_subscription.dao;

import com.zkxg.newspaper_subscription.model.entity.Newspaper;
import com.zkxg.newspaper_subscription.model.entity.User;

/**
 * @author xiaohu
 * @date 2022/10/11/ 10:58
 * @description 报刊dao层接口
 */
public interface NewspaperDao {
    // 增
    int add(Newspaper newspaper);
    // 删
    // 根据id
    int delete(Long id);
    // 改
    // 根据id
    int update(Long id);
    // 查
    // 根据id
    Newspaper getNewspaper(Long id);
}
