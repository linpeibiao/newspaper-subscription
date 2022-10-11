package com.zkxg.newspaper_subscription.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xiaohu
 * @date 2022/10/10/ 22:27
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // 主键id
    private Long id;
    // 账号
    private String account;
    // 密码
    private String password;
    // 昵称
    private String nackname;
    // 头像
    private String avatar;
    // 性别
    private Integer gender;
    // 手机
    private String phone;
    // 邮箱
    private String email;
    // 真实姓名
    private String realName;
    // 所属部门
    private String department;
    // 地址
    private String address;
    // 邮编
    private String postcode;
    // 用户状态
    private Integer state;
    // 用户角色
    private Integer role;
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
