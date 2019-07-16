package com.joey.demo.service;

import com.joey.demo.vo.AdminUserAdd;
import com.joey.demo.vo.AdminUserEdit;
import com.joey.demo.vo.EasyuiDataGridResult;
import org.springframework.web.bind.annotation.PathVariable;
import pojo.AdminUser;

import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
public interface AdminUserService {
   public AdminUser findUserByLoginName(String username);
   public List<AdminUser> findUsers();
   public EasyuiDataGridResult findAll(Integer page, Integer pageSize);//分页
   public EasyuiDataGridResult findAll(Integer page, Integer pageSize,String username);//查询
   public  int adminUserAdd(AdminUserAdd userAdd);//添加
   public  int adminUserEdit(AdminUserEdit userEdit);//编辑
   public int adminUserDelete(int id);//根据id删除
   public int adminUserDeleteBatch(String ids);//根据id删除批量
   public  AdminUser findUserById(@PathVariable("id") int id);//根据id查找user
}
