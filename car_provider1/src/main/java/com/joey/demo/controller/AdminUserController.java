package com.joey.demo.controller;

import com.joey.demo.service.AdminUserService;
import com.joey.demo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.AdminUser;

import java.util.List;

/**
 * Created by zhou on 2019/7/11.
 */
@Controller
public class AdminUserController {
    @Autowired
    private AdminUserService userService;

  /*  @RequestMapping("/adminuser/list")
    @ResponseBody
    public List<AdminUser> findAll(){
        List<AdminUser> users = userService.findUsers();
        return users;
    }*/

    @RequestMapping(value = "/adminuser/list",method = RequestMethod.POST)
    @ResponseBody
    public EasyuiDataGridResult findAll2(@RequestBody UserBatchQuery batchQuery){
      /*  int page=page1.getPage();
        int pageSize=page1.getPageSize();*/
      int page=batchQuery.getPage();
      int pageSize=batchQuery.getPageSize();
      String username=batchQuery.getUsername();
        EasyuiDataGridResult all = userService.findAll(page, pageSize,username);
        return  all;

    }
    @RequestMapping("/au/edit")
    @ResponseBody
    public int adminUserEdit(@RequestBody AdminUserEdit userEdit){

        int i = userService.adminUserEdit(userEdit);
        System.out.println(i+"up");
        return i;
    }
    @RequestMapping(value = "/au/add",method = RequestMethod.POST)
    @ResponseBody
    public int adminUserAdd(@RequestBody AdminUserAdd userAdd){

        int res=3;
        AdminUser loginName = userService.findUserByLoginName(userAdd.getUsername());

        if(loginName==null) {
            //不存在 添加
            res = userService.adminUserAdd(userAdd);
        }
        System.out.println(res);

        return  res;
    }

    @RequestMapping(value = "/au/delete",method = RequestMethod.POST)
    @ResponseBody
    public  int adminUserDelete(@RequestBody int id){
        int i = userService.adminUserDelete(id);
        return  i;
    }
    @RequestMapping(value = "/au/deletebatch",method = RequestMethod.POST)
    @ResponseBody
    public  int adminUserDeleteBatch(@RequestBody String ids){
        System.out.println(ids);
        int i = userService.adminUserDeleteBatch(ids);
        return i;

    }
    @RequestMapping(value = "/au/findbyid",method = RequestMethod.POST)
    @ResponseBody AdminUser findUserById(@RequestBody int id){
        AdminUser userById = userService.findUserById(id);
        return  userById;
    }

}
