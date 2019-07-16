package com.joey.demo.vo;

import lombok.Data;

/**
 * Created by zhou on 2019/7/11.
 */
@Data
public class AdminUserAdd {
    private  String username;
    private  String password;
    private  String is_Super;
    private  String dept;
    private String phone;
    private String email;
    private String remark;
    private String name;

    public AdminUserAdd() {
    }

    public AdminUserAdd(String username, String password, String is_Super, String dept, String phone, String email, String remark, String name) {
        this.username = username;
        this.password = password;
        this.is_Super = is_Super;
        this.dept = dept;
        this.phone = phone;
        this.email = email;
        this.remark = remark;
        this.name = name;
    }

    public AdminUserAdd(String username, String password, String is_Super, String dept, String phone, String email, String remark) {
        this.username = username;
        this.password = password;
        this.is_Super = is_Super;
        this.dept = dept;
        this.phone = phone;
        this.email = email;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AdminUserAdd{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", is_Super='" + is_Super + '\'' +
                ", dept='" + dept + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
