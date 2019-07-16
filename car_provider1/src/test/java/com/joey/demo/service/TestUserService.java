package com.joey.demo.service;

import com.joey.demo.vo.AdminUserAdd;
import com.joey.demo.vo.EasyuiDataGridResult;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.AdminUser;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserService {
    @Autowired
    private  AdminUserService userService;

    @Test
    public  void test8(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
       // new Date()为获取当前系统时间
      String string=  df.format(new Date());
        System.out.println(string);
        try {
            InetAddress addr =InetAddress.getLocalHost();
            String ip=addr.getHostAddress();
            System.out.println("Local ips: "+ip);
                    String hostname = addr.getHostName();
            System.out.println("Local hostname: "+hostname);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }



    }
    public  void test7(){
        AdminUser userById = userService.findUserById(17);
        System.out.println(userById);
    }
    public  void test6(){
        int i = userService.adminUserDelete(7);

    }
    public  void test5(){
        EasyuiDataGridResult all = userService.findAll(1, 10, "a");
        System.out.println(all);
    }
    public  void  test4(){
        Md5Hash md5Hash=new Md5Hash("sam",null,1024);
        String s1 = md5Hash.toString();
        System.out.println("sam"+s1);
        Md5Hash md5Hash1=new Md5Hash("rose",null,1024);
        String s11 = md5Hash1.toString();
        System.out.println("rose"+s11);
        Md5Hash md5Hash2=new Md5Hash("zoo",null,1024);
        String s12 = md5Hash2.toString();
        System.out.println("zoo"+s12);
        Md5Hash md5Hash3=new Md5Hash("ben",null,1024);
        String s13 = md5Hash3.toString();
        System.out.println("ben"+s13);
    }
    public void  test3(){
        AdminUserAdd userAdd=new AdminUserAdd("x","x","0","x","x","x","x","x") ;
        int i = userService.adminUserAdd(userAdd);


    }
    public  void test2(){
        List<AdminUser> users = userService.findUsers();
        System.out.println(users);

    }
    public  void  test(){
        AdminUser xx = userService.findUserByLoginName("admin");
        System.out.println(xx);

    }
}
