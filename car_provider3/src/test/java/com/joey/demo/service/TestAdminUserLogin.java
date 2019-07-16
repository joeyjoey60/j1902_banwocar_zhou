package com.joey.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.AdminUserLogin;

/**
 * Created by zhou on 2019/7/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestAdminUserLogin {

    @Autowired
    private  AdminUserLoginService userLoginService;
    @Test
    public void test2(){
        AdminUserLogin userLogin = userLoginService.findUserLogin();
        System.out.println(userLogin);
        userLoginService.adminUserLoginDelete();
    }
    @Test
    public  void test(){
        userLoginService.adminUserLoginAdd(new AdminUserLogin(1,"hanhan"));
    }
}
