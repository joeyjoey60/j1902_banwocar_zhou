package com.joey.demo.controller;

import com.joey.demo.service.RoleService;
import com.joey.demo.service.UserService;
import com.joey.demo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.AdminRole;
import pojo.AdminUser;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 2019/7/11.
 */
@Controller
public class AdminUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

  /*  @RequestMapping(value = "/au/list",method = RequestMethod.POST)
    @ResponseBody
    public List<AdminUser> findAll(){
        List<AdminUser> all = userService.findAll();
        return  all;
    }*/
  /*  @RequestMapping(value = "/au/list",method = RequestMethod.POST)
    @ResponseBody
    public  Object fetchUser(@RequestParam(value = "page",defaultValue = "1")Integer page,
                             @RequestParam(value = "rows",defaultValue = "10")Integer pageSize
    ){

        Page page1=new Page(page,pageSize);
        EasyuiDataGridResult users = userService.findAll2(page1);


       return  users;

    }*/


    @RequestMapping(value = "/au/delete", method = RequestMethod.POST)
    @ResponseBody
    public  MsgResult adminUserDelete(@RequestParam(value = "id")int id){
        int i = userService.adminUserDelete(id);
        MsgResult msgResult=new MsgResult();

        System.out.println(id);
        if (i>0){
            msgResult.setStatus(200);
            msgResult.setMessage("删除成功");

        }
        else {
            msgResult.setMessage("删除失败");
            msgResult.setStatus(400);
        }

        return  msgResult;
    }

    @RequestMapping(value = "/au/deletebatch",method = RequestMethod.POST)
    @ResponseBody
    public int adminUserDeleteBatch(@RequestParam(value = "ids",defaultValue = "")String ids){
      //  System.out.println(ids);
        int i = userService.adminUserDeleteBatch(ids);

        return  i;
    }
    @RequestMapping(value = "/au/list", method = RequestMethod.POST)
    @ResponseBody
    public Object fetchUser(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                            @RequestParam(value = "username", defaultValue = "") String username
    ) {

        UserBatchQuery userBatchQuery = new UserBatchQuery(page, pageSize, username);
       /* EasyuiDataGridResult users = userService.findAll2(page1);


        return  users;*/
      //  System.out.println(username + "ttttttttttt");
        EasyuiDataGridResult dataGridResult = userService.findAll2(userBatchQuery);
        return dataGridResult;

    }


    @RequestMapping(value = "/au/add", method = RequestMethod.POST)
    @ResponseBody
    public int adminUserAdd(AdminUserAdd userAdd) {

       // System.out.println(userAdd);
        int result = userService.adminUserAdd(userAdd);


        return result;
    }
    @RequestMapping(value = "/au/edit", method = RequestMethod.POST)
    @ResponseBody
    public int adminUserEdit(AdminUserEdit userEdit) {

        // System.out.println(userAdd);
   /*     int result = userService.adminUserAdd(userAdd);*/
        int i = userService.adminUserEdit(userEdit);



        return i;
    }
    @RequestMapping(value = "/au/showedit")
    public String adminUserShowEdit(int id, HttpServletRequest request){
    //    System.out.println(id);
        List<AdminRole> list=new ArrayList<>();
        list.add(new AdminRole(1,"技术部"));
        list.add(new AdminRole(2,"人事部"));
        list.add(new AdminRole(5,"软件部"));
        List<AdminRole> roles = roleService.findRoles();
        request.setAttribute("roles",roles);
        List<UserShowSuper> supers=new ArrayList<>();
        supers.add(new UserShowSuper("普通管理员",0));
        supers.add(new UserShowSuper("超级管理员",1));
        request.setAttribute("supers",supers);
        AdminUser userById = userService.findUserById(id);
       request.setAttribute("user",userById);

        return  "guanliyuanedit";

    }

}
