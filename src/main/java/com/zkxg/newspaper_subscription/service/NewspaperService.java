package com.zkxg.newspaper_subscription.service;

import com.zkxg.newspaper_subscription.model.entity.Newspaper;

/**
 * @author xiaohu
 * @date 2022/10/13/ 21:27
 * @description 报刊业务逻辑接口
 */
public interface NewspaperService {
    // 添加报刊
    int add(Newspaper newspaper);
}
