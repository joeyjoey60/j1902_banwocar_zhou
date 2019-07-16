package com.joey.demo.controller;

import com.joey.demo.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.AdminRole;

import java.util.List;

/**
 * Created by zhou on 2019/7/11.
 */
@Controller
public class AdminRoleController {

    @Autowired
    private AdminRoleService roleService;

    @RequestMapping(value = "/ar/list",method = RequestMethod.POST)
    @ResponseBody
    public List<AdminRole> findRoles(){
        List<AdminRole> roles = roleService.findRoles();
        return  roles;
    }
}
