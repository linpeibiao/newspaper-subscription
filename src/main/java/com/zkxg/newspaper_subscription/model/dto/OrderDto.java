package com.zkxg.newspaper_subscription.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author xiaohu
 * @date 2022/10/15/ 15:13
 * @description 生成订阅订单的数据传输对象实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    // 用户id
    private Long userId;
    // 用户名称
    private String userName;
    // 报刊id
    private Long newspaperId;
    // 报刊名称
    private String newspaperName;
    // 订阅周期
    private Integer period;
    // 订阅份数
    private Integer count;
    // 订阅单价
    private BigDecimal singlePrice;
    // 总价格
    private BigDecimal totalPrice;
    // 备注
    private String remark;
}
