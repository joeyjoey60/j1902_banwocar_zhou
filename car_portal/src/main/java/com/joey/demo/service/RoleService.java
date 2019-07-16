package com.joey.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.AdminRole;

import java.util.List;

/**
 * Created by zhou on 2019/7/12.
 */
@FeignClient(value = "zhou-provider2")
public interface RoleService {
    @RequestMapping( value = "/ar/list",method = RequestMethod.POST)
    public List<AdminRole> findRoles();
}
