package com.joey.demo.service;


import com.joey.demo.pojo.AdminUser;

/**
 * Created by zhou on 2019/7/10.
 */
public interface AdminUserService {
    //根据loginname查询adminuser
    public AdminUser findUserByLoginName(String username);

}
