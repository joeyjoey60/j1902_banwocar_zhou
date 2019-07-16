package com.joey.demo.service;

import com.joey.demo.pojo.AdminUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhou on 2019/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestAdminUserService {
    @Autowired
    private  AdminUserService userService;

    @Test
    public  void  test(){
        AdminUser xx = userService.findUserByLoginName("admin");
        System.out.println(xx.toString());

    }
}
