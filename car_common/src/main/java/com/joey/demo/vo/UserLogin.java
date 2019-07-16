package com.joey.demo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zhou on 2019/7/10.
 */
@Data
public class UserLogin implements Serializable {
    private  String username;
    private  String password;
    private String verifycode;
}
