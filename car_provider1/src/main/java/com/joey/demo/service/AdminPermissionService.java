package com.joey.demo.service;

import org.apache.ibatis.annotations.Param;
import pojo.AdminPermission;
import pojo.AdminUser;

import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
public interface AdminPermissionService {
    //根据username查找权限
    public List<AdminPermission> findPermissionByLoginName(@Param("username") String username);



}
