package com.zkxg.newspaper_subscription.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author xiaohu
 * @date 2022/10/17/ 20:27
 * @description 用户报刊开销详情
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCostInfo {
    // 用户id
    private Long userId;
    // 总开销
    private BigDecimal totalCost;
    // 各类型占比
    private Map<String, BigDecimal> typePercentage;
}
