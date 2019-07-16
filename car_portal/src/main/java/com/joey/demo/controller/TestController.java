package com.joey.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhou on 2019/7/11.
 */
@Controller
@RequestMapping("/test")
@RequiresPermissions(value={"user_forbiden"})
public class TestController {


    @RequestMapping("/two")
    public String showTwoView(){
        return "two";
    }


}
