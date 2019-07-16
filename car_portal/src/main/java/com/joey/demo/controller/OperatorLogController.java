package com.joey.demo.controller;

import com.joey.demo.service.AdminUserLoginService;
import com.joey.demo.service.OperateLogService;
import com.joey.demo.service.UserService;
import com.joey.demo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.AdminUser;
import pojo.AdminUserLogin;
import pojo.OperateLog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/7/12.
 */
@Controller
public class OperatorLogController {

    @Autowired
    private OperateLogService logService;
    @Autowired
    private  UserService userService;
    @Autowired
    private AdminUserLoginService userLoginService;
   /* @RequestMapping(value = "/ol/list",method = RequestMethod.POST)
    @ResponseBody
    public List<OperatorLogShow> findAll(HttpSession session){
       // String uname =(String) session.getAttribute("uname");
        String uname="admin";
        System.out.println(uname+"ol");
        AdminUser userByLoginName = userService.findUserByLoginName(uname);
        Integer uid = userByLoginName.getId();
        List<OperateLog> allLogs =null;
        if(userByLoginName.getIsSuper()==1){
            //超级管理员
            allLogs = userService.findAllLogs();
        }else if(userByLoginName.getIsSuper()==0){
            //普通管理员
          allLogs=  userService.findAllLogsByUname(uid);



        }
*/

    @RequestMapping(value = "/olt/lists",method = RequestMethod.POST)
    @ResponseBody
    public List<OperatorLogShow> findAll(){
        // String uname =(String) session.getAttribute("uname");
        AdminUserLogin userLogin = userLoginService.findUserLogin();
       /* String uname="admin";*/
       String uname =userLogin.getUname();
        //System.out.println(uname+"ol");
        AdminUser userByLoginName = userService.findUserByLoginName(uname);
        Integer uid = userByLoginName.getId();
        int issuper=userByLoginName.getIsSuper();
        List<OperateLog> allLogs =null;
        if(issuper ==1) {
            allLogs = logService.findAllLogs();
        }
        else {
            allLogs=logService.findAllLogsByUname(uid);

        }
        List<OperatorLogShow> logShows= new ArrayList<>();
        for(OperateLog l:allLogs){
            Integer uid1 = l.getOperateUid();
            AdminUser userById = userService.findUserById(uid1);
            OperatorLogShow logShow=new OperatorLogShow(userById.getUsername(),l.getOperateTime(),l.getId(),l.getTableName(),l.getOperateDesc());
            logShows.add(logShow);
        }
        System.out.println(logShows);
        return  logShows;
    }

    @RequestMapping(value = "/olt/listpage", method = RequestMethod.POST)
    @ResponseBody
    public Object fetchOperateLog(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                            @RequestParam(value = "title", defaultValue = "") String username,
                                  @RequestParam(value = "time1",defaultValue = "")String time1,
                                  @RequestParam(value="time2",defaultValue = "")String time2
    ) {
        System.out.println(time1+"cccccccccccc"+time2);
        Date d1 =null;
        Date d2 =null;
        if(time1.length()>2){
            d1 = getDate(time1);
        }
        if(time2.length()>2){
            d2 = getDate(time2);
        }
        System.out.println(d1+"dddddd"+d2);



        UserBatchQuery userBatchQuery = new UserBatchQuery(page, pageSize, username);
        //like admin
        OperatoLogBatchQueryLike logLike=new OperatoLogBatchQueryLike(page,pageSize,username,d1,d2);
        AdminUserLogin userLogin = userLoginService.findUserLogin();
        String uname =userLogin.getUname();
        //System.out.println(uname+"ol");
        AdminUser userByLoginName = userService.findUserByLoginName(uname);
        Integer uid = userByLoginName.getId();
        OperatoLogBatchQuery operatoLogBatchQuery=new OperatoLogBatchQuery(uid,page,pageSize,username);
       OperatoLogBatchQueryLikeUid logBatchQueryLikeUid=new OperatoLogBatchQueryLikeUid(uid,page,pageSize,username,d1,d2);

        int issuper=userByLoginName.getIsSuper();
        EasyuiDataGridResult allLogs =null;
        if(issuper ==1) {
            //
            allLogs = logService.findAll2(userBatchQuery);
        }
        else {
            allLogs=logService.findAll3Uid(operatoLogBatchQuery);

        }


        //  System.out.println(username + "ttttttttttt");
       return  allLogs;

    }

    public static  Date getDate(String time){

        String[] split = time.split(" ");
        System.out.println(split[0]+"    "+split[1]);
        String[] split1 = split[0].split("-");
        String[] split2 = split[1].split(":");
        String year=split1[0];
        int y=Integer.parseInt(split1[0]);
        int m=Integer.parseInt(split1[1]);
        int d=Integer.parseInt(split1[2]);
        int h=Integer.parseInt(split2[0]);
        int M=Integer.parseInt(split2[1]);
        int S=Integer.parseInt(split2[2]);

        Date date=new Date(y,m,d,h,M,S);
        return  date;
    }



}
