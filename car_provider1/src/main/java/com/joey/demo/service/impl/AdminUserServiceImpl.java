package com.joey.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.joey.demo.mapper.AdminUserMapper;
import com.joey.demo.service.AdminUserService;
import com.joey.demo.vo.AdminUserAdd;
import com.joey.demo.vo.AdminUserEdit;
import com.joey.demo.vo.EasyuiDataGridResult;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.AdminUser;
import pojo.AdminUserExample;

import javax.annotation.Resource;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper userMapper;
    @Override
    public AdminUser findUserByLoginName(String username) {
        AdminUser adminUser = userMapper.findUserByLoginName(username);
        return adminUser;
    }

    @Override
    public List<AdminUser> findUsers() {

        AdminUserExample userExample=new AdminUserExample();
        List<AdminUser> adminUsers = userMapper.selectByExample(userExample);
        return adminUsers;
    }

    @Override
    public EasyuiDataGridResult findAll(Integer page, Integer pageSize) {

        EasyuiDataGridResult dataGridResult =new EasyuiDataGridResult();
        AdminUserExample adminUserExample=new AdminUserExample();
        //在原查询基础上添加分页功能
        PageHelper.startPage(page,pageSize);
        //执行查询方法
        List<AdminUser> adminUsers = userMapper.selectByExample(adminUserExample);
        //从数据集合中提取分页信息
        PageInfo<AdminUser> pageInfo=new PageInfo<>(adminUsers);
        dataGridResult.setRows(adminUsers);//设置当前结果集
        //  System.out.println(tbItems+"]]]]]]]]]]]]]");
        long total = pageInfo.getTotal();//获取总记录数
        dataGridResult.setTotal(total);
        return  dataGridResult;

    }

    @Override
    public int adminUserAdd(AdminUserAdd userAdd) {

        Byte i = Byte.parseByte(userAdd.getIs_Super());
        Md5Hash md5Hash=new Md5Hash(userAdd.getPassword(),null,1024);
        String s1 = md5Hash.toString();
        
        AdminUser adminUser=new AdminUser(userAdd.getUsername(),s1,userAdd.getName(),userAdd.getPhone(),
             userAdd.getEmail(),i,userAdd.getRemark(),userAdd.getDept());
        int i1 = userMapper.adminUserAdd(adminUser);



        return i1;
    }

    @Override
    public int adminUserEdit(AdminUserEdit userAdd) {
        Byte i = Byte.parseByte(userAdd.getIs_Super());
        Md5Hash md5Hash=new Md5Hash(userAdd.getPassword(),null,1024);
        String s1 = md5Hash.toString();
       // updateByPrimaryKeySelective
        AdminUser adminUser=new AdminUser(userAdd.getId(),userAdd.getUsername(),s1,userAdd.getName(),userAdd.getPhone(),
                userAdd.getEmail(),i,userAdd.getRemark(),userAdd.getDept());
        int i1 = userMapper.updateByPrimaryKeySelective(adminUser);

        return i1;
    }

    @Override
    public EasyuiDataGridResult findAll(Integer page, Integer pageSize, String username) {

        EasyuiDataGridResult dataGridResult=new EasyuiDataGridResult();
        AdminUserExample example=new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();
        //创建查询条件对象
        if(!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%"+username+"%");

        }
        //查询结果添加分页功能
        PageHelper.startPage(page,pageSize);
      //  List<adm> tbItems = itemMapper.selectByExample(itemExample);
        List<AdminUser> users = userMapper.selectByExample(example);
        PageInfo<AdminUser> pageInfo=new PageInfo<>(users);//分页后
        dataGridResult.setRows(users);//设置当前页结果集
        long total = pageInfo.getTotal();
        dataGridResult.setTotal(total);

        return dataGridResult;
    }

    @Override
    public int adminUserDelete(int id) {

        int i = userMapper.deleteByPrimaryKey(id);

        return i;
    }

    @Override
    public int adminUserDeleteBatch(String ids) {
        String[] split = null;
        if(!StringUtils.isEmpty(ids)){
            split=ids.split(",");

        }
        AdminUserExample example=new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();

        List<String> list = Arrays.asList(split);
        //字符串转为long
        List<Integer> integers=new ArrayList<>();
        for(String s:list){
            int i1 = Integer.parseInt(s);
            integers.add(i1);
        }
        criteria.andIdIn(integers);
        int i = userMapper.deleteByExample(example);
        return i;
    }

    @Override
    public AdminUser findUserById(int id) {

        AdminUser adminUser = userMapper.selectByPrimaryKey(id);
        return adminUser;
    }
}
