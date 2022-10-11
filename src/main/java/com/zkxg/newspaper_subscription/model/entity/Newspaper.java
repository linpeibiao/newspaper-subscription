package com.zkxg.newspaper_subscription.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaohu
 * @date 2022/10/11/ 9:59
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Newspaper {
    // 主键id
    private Long id;
    // 报刊名称
    private String name;
    // 报刊号
    private String newspaperNumber;
    // 封面
    private String cover;
    // 类别
    private String type;
    // 出版社
    private String publisher;
    // 出版时间
    private String publishTime;
    // 订阅单价
    private BigDecimal price;
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
    private Boolean deleted;
}
