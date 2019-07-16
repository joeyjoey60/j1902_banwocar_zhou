package com.joey.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.OperateLog;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestOperatorLog {

    @Autowired
    private  OperateLogService operateLogService;

    @Test
    public void test3(){
      //  Date d=new Date("2019-07-12 15:56");
        String[] split = "2019-07-12 15:56".split(" ");
        System.out.println(split[0]+"    "+split[1]);
        String[] split1 = split[0].split("-");
        String[] split2 = split[1].split(":");
        String year=split1[0];
        int y=Integer.parseInt(split1[0]);
        int m=Integer.parseInt(split1[1]);
        int d=Integer.parseInt(split1[2]);
        int h=Integer.parseInt(split2[0]);
        int M=Integer.parseInt(split2[1]);

        Date date=new Date(y,m,d,h,M);
        System.out.println(date);


    }
    public  void test2(){
        List<OperateLog> operateLogs = operateLogService.finLogsByUid(9);
        System.out.println(operateLogs);

    }
    @Test
    public void test(){
        operateLogService.opedateLogAdd(new OperateLog(1,"192.168.56.1","成功登陆后台系统","admin"));
    }
}
