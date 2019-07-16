package com.joey.demo.service.impl;

import com.joey.demo.mapper.AdminRoleMapper;
import com.joey.demo.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.AdminRole;
import pojo.AdminRoleExample;

import java.util.List;

/**
 * Created by zhou on 2019/7/11.
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleMapper roleMapper;
    @Override
    public List<AdminRole> findRoles() {
        AdminRoleExample example=new AdminRoleExample();
        List<AdminRole> roles = roleMapper.selectByExample(example);
        return roles;
    }
}
