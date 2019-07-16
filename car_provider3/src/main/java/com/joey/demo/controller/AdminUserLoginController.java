package com.joey.demo.controller;

import com.joey.demo.service.AdminUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.AdminUserLogin;

/**
 * Created by zhou on 2019/7/13.
 */
@Controller
public class AdminUserLoginController {
    @Autowired
    private AdminUserLoginService userLoginService;

    @RequestMapping(value = "/aul/find",method = RequestMethod.POST)
    @ResponseBody
    public AdminUserLogin findUserLogin(){

        AdminUserLogin userLogin = userLoginService.findUserLogin();
        return  userLogin;
    }



    @RequestMapping(value = "/aul/add",method = RequestMethod.POST)
    @ResponseBody
    public  int addUserLogin(@RequestBody String uname){
        AdminUserLogin userLogin=new AdminUserLogin(1,uname);
        int i = userLoginService.adminUserLoginAdd(userLogin);
        return  i;
    }
}
