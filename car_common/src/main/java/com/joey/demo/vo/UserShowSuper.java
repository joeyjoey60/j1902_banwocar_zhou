package com.joey.demo.vo;

import lombok.Data;

/**
 * Created by zhou on 2019/7/12.
 */
@Data
public class UserShowSuper {
    private  String name;
    private  int value;

    public UserShowSuper(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
