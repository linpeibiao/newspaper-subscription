package com.zkxg.newspaper_subscription.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaohu
 * @date 2022/10/11/ 15:08
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    // 账号
    private String account;
    // 手机号
    private String phone;
    // 密码
    private String password;
}
