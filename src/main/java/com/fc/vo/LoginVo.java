package com.fc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo {
    //请求id
    private String requestId;

    //操作人
    private String operator;

    //账号
    private String account;

    //密码
    private String password;

    //验证码
    private String captcha;

    //类型(权限)
    private String type;
}
