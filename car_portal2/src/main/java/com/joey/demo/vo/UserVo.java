package com.joey.demo.vo;

import lombok.Data;

/**
 * Created by zhou on 2019/7/10.
 */
@Data
public class UserVo {
    private String username;//登录名
    private String password;//密码

    private String verifyCode;//验证码
}
