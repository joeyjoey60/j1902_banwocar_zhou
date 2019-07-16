package com.joey.demo.service.impl;

import com.joey.demo.mapper.AdminUserMapper;

import com.joey.demo.pojo.AdminUser;
import com.joey.demo.pojo.AdminUserExample;
import com.joey.demo.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper userMapper;

    @Override
    public AdminUser findUserByLoginName(String username) {
      /*  AdminUserExample example=new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();*/
        AdminUser adminUser = userMapper.findOneByName(username);


        return adminUser;
    }
}
