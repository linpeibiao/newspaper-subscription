package com.zkxg.newspaper_subscription.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaohu
 * @date 2022/10/17/ 15:48
 * @description 用于管理员统计的报刊信息类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewspaperInfo {
    // 报刊id
    private Long newspaperId;
    // 报刊名称
    private String newspaperName;
    // 封面图片
    private String cover;
    // 类别
    private String type;
    // 出版社
    private String publisher;
    // 订单数量
    private Integer orderQuantity;
}
