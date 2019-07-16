package com.joey.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.AdminUserLogin;

/**
 * Created by zhou on 2019/7/13.
 */
@FeignClient(value = "zhou-provider3")
public interface AdminUserLoginService {
    @RequestMapping(value = "/aul/find",method = RequestMethod.POST)
    public AdminUserLogin findUserLogin();

    @RequestMapping(value = "/aul/add",method = RequestMethod.POST)
    public  int addUserLogin(String uname);

}
