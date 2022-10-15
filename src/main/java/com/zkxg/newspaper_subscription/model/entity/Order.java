package com.zkxg.newspaper_subscription.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaohu
 * @date 2022/10/11/ 10:42
 * @description 订单表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    // 主键id
    private Long id;
    // 订单号
    private String orderNumber;
    // 用户id
    private Long userId;
    // 报刊id
    private Long newspaperId;
    // 订阅周期
    private Integer period;
    // 订阅周期单位
    private String subscriptUnit;
    // 订阅份数
    private Integer count;
    // 总价格
    private BigDecimal totalPrice;
    // 到期时间
    private Date expiryTime;
    // 备用字段1
    private String backup1;
    // 备用字段2
    private String backup2;
    // 备注
    private String remark;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
    // 逻辑删除
    private Integer deleted;
}
