package com.joey.demo.service;

import com.joey.demo.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pojo.AdminPermission;
import pojo.AdminUser;

import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
@FeignClient(value = "zhou-provider1")
public interface UserService {
    @RequestMapping("/{page}")
    public String showPage(@PathVariable("page") String page);

    @RequestMapping("/dologin")
    public MsgResult dologin(UserLogin userLogin);

    @RequestMapping("/findUserByLoginName")
    public AdminUser findUserByLoginName(String username);

    @RequestMapping("/findPermissionByLoginName")
    public List<AdminPermission> findPermissionByLoginName(String username);

    /* @RequestMapping("/adminuser/list")
     public EasyuiDataGridResult findAll2(Page page1);*/
    @RequestMapping("/adminuser/list")
    public EasyuiDataGridResult findAll2(UserBatchQuery batchQuery);





    @RequestMapping("/au/add")
    public int adminUserAdd(AdminUserAdd userAdd);

    @RequestMapping("/au/edit")
    public int adminUserEdit(AdminUserEdit userEdit);
    @RequestMapping("/au/delete")
    public int adminUserDelete(int id);
    @RequestMapping("/au/deletebatch")
    public  int adminUserDeleteBatch(String ids);

    @RequestMapping(value = "/au/findbyid")
    public AdminUser findUserById(int id);




}
