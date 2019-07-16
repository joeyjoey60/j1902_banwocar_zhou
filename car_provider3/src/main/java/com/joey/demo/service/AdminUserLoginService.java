package com.joey.demo.service;

import pojo.AdminUserLogin;

/**
 * Created by zhou on 2019/7/13.
 */
public interface AdminUserLoginService {
    public int adminUserLoginAdd(AdminUserLogin userLogin);//添加
    public  AdminUserLogin findUserLogin();//查找当前登录用户
    public  int  adminUserLoginDelete();//删除
}
