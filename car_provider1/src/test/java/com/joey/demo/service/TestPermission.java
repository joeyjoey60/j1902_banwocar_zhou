package com.joey.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.AdminPermission;

import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestPermission {

    @Autowired
    private AdminPermissionService permissionService;

    @Test
    public  void  test(){
        List<AdminPermission> admin = permissionService.findPermissionByLoginName("admin");
        System.out.println(admin);

    }
}
