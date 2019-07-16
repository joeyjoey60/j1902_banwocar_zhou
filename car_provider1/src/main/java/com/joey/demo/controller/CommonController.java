package com.joey.demo.controller;

import com.joey.demo.service.AdminPermissionService;
import com.joey.demo.service.AdminUserService;
import com.joey.demo.utils.ImgCode;
import com.joey.demo.vo.MsgResult;
import com.joey.demo.vo.UserLogin;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.AdminPermission;
import pojo.AdminUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by zhou on 2019/7/9.
 */
@Controller
public class CommonController {
@Autowired
private AdminUserService userService;
@Autowired
private AdminPermissionService permissionService;

    @RequestMapping("/{page}")
    public  String showPage(@PathVariable("page")String page){


        return  page;
    }

    @RequestMapping("/dologin")
    @ResponseBody
    public MsgResult dologin(@RequestBody UserLogin userLogin){
        MsgResult result=new MsgResult();
        System.out.println("rrrrrrrrrrrrrrr"+userLogin);
        result.setStatus(200);
        result.setMessage("xxxxxxxx");
        return result;
    }

    @RequestMapping("/findUserByLoginName")
    @ResponseBody
    public AdminUser findUserByLoginName(@RequestBody String username){
        AdminUser adminUser = userService.findUserByLoginName(username);
        return  adminUser;
    }

    @RequestMapping("/findPermissionByLoginName")
    @ResponseBody
    public List<AdminPermission> findPermissionByLoginName( @RequestBody String username){
        return  permissionService.findPermissionByLoginName(username);
    }




}
