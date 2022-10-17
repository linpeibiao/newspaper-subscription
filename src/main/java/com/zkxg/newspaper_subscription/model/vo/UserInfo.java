package com.zkxg.newspaper_subscription.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author xiaohu
 * @date 2022/10/17/ 12:14
 * @description 用于管理员统计的用户信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    // 用户id
    private Long userId;
    // 用户昵称
    private String nackname;
    // 用户账号
    private String account;
    // 用户头像
    private String avatar;
    // 用户消费总金额
    private BigDecimal totalCost;
    // 用户订单总数
    private Integer orderQuantity;
}
