package com.joey.demo.controller;

import com.joey.demo.pojo.AdminUser;
import com.joey.demo.service.AdminUserService;
import com.joey.demo.utils.ImgCode;
import com.joey.demo.utils.MD5;
import com.joey.demo.utils.SessionKey;
import com.joey.demo.vo.UserVo;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
@Controller
public class CommonController {
    @Autowired
    private AdminUserService userService;

    @RequestMapping("/{page}")
    public  String showPage(@PathVariable("page")String page){


        return  page;
    }

    @RequestMapping(value="/user/login",method = RequestMethod.POST)
    public  String  login(UserVo userVo, HttpSession session){
        System.out.println(userVo);
//        1、判定验证码是否有效
//        2、有效验证码，根据用户名查询用户信息
//        3、用户信息有效，再进行凭证比对（包含加密），密文校验
//        4、根据用户名搜索菜单信息和权限信息
//        5、对用户信息及权限信息脱密，暂存在本地内存中（session）
//        6、返回显示视图
       String verify = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);//从session中获取存储的验证码
        if(StringUtils.startsWithIgnoreCase(verify,userVo.getVerifyCode())){//验证码有效//1.
            //2.

            AdminUser adminUser = userService.findUserByLoginName(userVo.getUsername());
            if(adminUser!=null){//3.
                //3.1对登录的密码加密
                String md5ofStr = new MD5().getMD5ofStr(userVo.getPassword());
                System.out.println(md5ofStr);
                adminUser.getPassword().equalsIgnoreCase(md5ofStr);
                if(adminUser.getPassword().equalsIgnoreCase(md5ofStr)){//3.2密文比对
                    adminUser.setPassword(null);//4.
                    session.setAttribute(SessionKey.SYS_USER,adminUser);//5
                    session.setAttribute(SessionKey.SYS_USERNAME,adminUser.getUsername());//5
//                    根据用户名查询权限信息
                  /*  List<SysPermission> sysPermissions = userService.selectPermissionsByLoginName(userVo.getLoginName());
//                        将权限信息写入session中，已被后期校验
                    session.setAttribute(SessionKey.CURR_PERMS,sysPermissions);*/
                    return  "htindex";
                }else{//3.3密码无效
                    return "htlogin";
                }
            }else{// 3 f  用户无效
                return "htlogin";
            }
        }else{//1 验证码无效
            return "htlogin";
        }


    }


    @RequestMapping(value="/getImage" ,method=RequestMethod.GET)
    public void getVerifyImage(HttpServletRequest request, HttpServletResponse response){
        ImgCode imgCode = new ImgCode();
        imgCode.getRandcode(request,response);

    }
}
