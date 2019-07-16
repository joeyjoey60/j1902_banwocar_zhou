package com.joey.demo.service.impl;

import com.joey.demo.mapper.AdminUserLoginMapper;
import com.joey.demo.service.AdminUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.AdminUserLogin;
import pojo.AdminUserLoginExample;

import java.util.List;

/**
 * Created by zhou on 2019/7/13.
 */
@Service
public class AdminUserLoginServiceImpl implements AdminUserLoginService {

    @Autowired
    private AdminUserLoginMapper userLoginMapper;
    @Override
    public int adminUserLoginAdd(AdminUserLogin userLogin) {
        AdminUserLoginExample userLoginExample=new AdminUserLoginExample();
        int i1 = userLoginMapper.deleteByExample(userLoginExample);
        int insert = userLoginMapper.insert(userLogin);
        return insert;
    }

    @Override
    public AdminUserLogin findUserLogin() {

        AdminUserLoginExample userLoginExample=new AdminUserLoginExample();
        AdminUserLoginExample.Criteria criteria = userLoginExample.createCriteria();
         criteria.andIdEqualTo(1);
        List<AdminUserLogin> adminUserLogins = userLoginMapper.selectByExample(userLoginExample);
        AdminUserLogin adminUserLogin=adminUserLogins.get(0);
        return adminUserLogin;
    }

    @Override
    public int adminUserLoginDelete() {
        AdminUserLoginExample userLoginExample=new AdminUserLoginExample();
        AdminUserLoginExample.Criteria criteria = userLoginExample.createCriteria();
        criteria.andIdEqualTo(1);
        int i = userLoginMapper.deleteByExample(userLoginExample);
        return i;
    }
}
