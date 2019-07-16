package com.joey.demo.controller;

import com.joey.demo.service.AdminUserLoginService;
import com.joey.demo.service.OperateLogService;
import com.joey.demo.service.RoleService;
import com.joey.demo.service.UserService;
import com.joey.demo.utils.ImgCode;
import com.joey.demo.vo.MsgResult;
import com.joey.demo.vo.UserLogin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhou on 2019/7/9.
 */
@Controller
public class UserCommoneController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AdminUserLoginService loginService;
    @Autowired
    private OperateLogService operateLogService;

    @RequestMapping("/")
    public String showindex() {
        return "htlogin";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public String dologin(UserLogin userLogin, HttpServletRequest request, HttpSession session) {
    //    System.out.println("tttttttttttttt" + userLogin.getVerifycode());
        String str1="";
        String verify = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);//从session中获取存储的验证码
      //  System.out.println(verify+"yzzzzzzzzzzzzzzz");
        if(verify.equalsIgnoreCase(userLogin.getVerifycode())){
        //验证码有效//1.
            if (userLogin != null) {

                try {
                    Subject subject = SecurityUtils.getSubject();
                    UsernamePasswordToken token = new UsernamePasswordToken(userLogin.getUsername(), userLogin.getPassword());
                    subject.login(token);

                    if (subject.isAuthenticated()) {//判定登录是否成功
                        request.getSession().setAttribute("uname", userLogin.getUsername());
                        String username=userLogin.getUsername();


                        loginService.addUserLogin(userLogin.getUsername());
                        AdminUser userByLoginName = userService.findUserByLoginName(userLogin.getUsername());
                        int uid=userByLoginName.getId();

                        InetAddress addr =InetAddress.getLocalHost();
                        String ip=addr.getHostAddress();
                        int i1=operateLogService.addOperateLog(new OperateLog(uid,ip,"成功登陆后台系统",username));
                        String str;
                        Byte isSuper = userByLoginName.getIsSuper();
                        if (isSuper == 1) {
                            str = "超级管理员";
                        } else {
                            str = "普通管理员";
                        }
                        request.getSession().setAttribute("issuper", str);

                        str1= "登录成功";

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                str1= "登录失败";
            }
        }else {
            str1= "验证码错误";
        }
      return  str1;

    }

    //注销用户
    @RequestMapping("/logout")
    public String logOut(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();//退出操作（清除用户缓存数据）

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:htlogin";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable("page") String page) {
        return page;
    }

    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    public void getVerifyImage(HttpServletRequest request, HttpServletResponse response) {
        ImgCode imgCode = new ImgCode();
        imgCode.getRandcode(request, response);

    }

    @RequestMapping("/testshiro")
    @ResponseBody
    public List<AdminPermission> findPermissionByLoginName() {
        List<AdminPermission> admin = userService.findPermissionByLoginName("admin");
        return admin;
    }

    @RequestMapping("/testshiro2")
    @ResponseBody
    public AdminUser findUserByLoginName() {
        AdminUser admin = userService.findUserByLoginName("admin");
     //   System.out.println(admin);
        return admin;
    }

    @RequestMapping(value = "/ar/list")
    @ResponseBody
    public  List<AdminRole> findRoles(){
    //    System.out.println("rrrrrrrr");

        List<AdminRole> list = roleService.findRoles();
    //   System.out.println("cccc"+list);

       return  list;
    }
    @RequestMapping(value = "/showrole")
    public ModelAndView findRoles2(){

        List<AdminRole> list=new ArrayList<>();
        list.add(new AdminRole(1,"技术部"));
        list.add(new AdminRole(2,"人事部"));
        list.add(new AdminRole(5,"软件部"));
      //  System.out.println(list);
       // List<AdminRole> list2 = userService.findRoles();
       // System.out.println("cccc"+list);
        List<AdminRole> roles = roleService.findRoles();
        ModelAndView modelAndView=new ModelAndView();
      modelAndView.addObject("roles", roles);
        modelAndView.setViewName("guanliyuanadd");
      //  model.addAttribute("roles",list2);
        return  modelAndView;
    }

    @RequestMapping("/aul/find")
    @ResponseBody
    public AdminUserLogin findOne(){
        AdminUserLogin userLogin = loginService.findUserLogin();
        return  userLogin;
    }
    @RequestMapping("/aul/add")
    @ResponseBody
    public  int adminUserLoginAdd(@RequestParam("uname") String uname){
        int i = loginService.addUserLogin(uname);
        return  i;
    }



}
