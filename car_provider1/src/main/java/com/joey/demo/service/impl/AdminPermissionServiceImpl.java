package com.joey.demo.service.impl;

import com.joey.demo.mapper.AdminPermissionMapper;
import com.joey.demo.service.AdminPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.AdminPermission;

import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
@Service
public class AdminPermissionServiceImpl implements AdminPermissionService {

    @Autowired
    private AdminPermissionMapper permissionMapper;

    @Override
    public List<AdminPermission> findPermissionByLoginName(String username) {
        return permissionMapper.findPermissionByLoginName(username);
    }
}
