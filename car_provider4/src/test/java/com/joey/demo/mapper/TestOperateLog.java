package com.joey.demo.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.OperateLog;
import pojo.OperateLogExample;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/7/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Configuration("com.joey.demo.mapper")
public class TestOperateLog {
    @Autowired
    private OperateLogMapper logMapper;

    @Test
    public  void test(){
        Date d1=null;
        Date d2=null;
        OperateLogExample logExample=new OperateLogExample();
        OperateLog log = logMapper.selectByPrimaryKey(1L);
        Date operateTime = log.getOperateTime();
        Date date = new Date(2019, 07, 13, 15, 39,03);
        System.out.println(operateTime+";;;;;;;;"+date);
        long time = date.getTime();
       logExample.createCriteria().andOperateTimeEqualTo(date);
               //andOperateTimeLessThan(new Date(2017,7,12,12,57));
               //andOperateTimeLessThanOrEqualTo(new Date(2017,7,12,12,57));

        List<OperateLog> logs = logMapper.selectByExample(logExample);
        System.out.println(logs.size());
    }
}
