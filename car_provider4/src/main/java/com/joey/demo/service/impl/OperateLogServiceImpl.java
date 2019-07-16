package com.joey.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.joey.demo.mapper.OperateLogMapper;
import com.joey.demo.service.OperateLogService;
import com.joey.demo.vo.EasyuiDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.w3c.dom.ls.LSException;
import pojo.AdminUser;
import pojo.OperateLog;
import pojo.OperateLogExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/7/12.
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public List<OperateLog> findAll() {
        OperateLogExample logExample=new OperateLogExample();

        List<OperateLog> operateLogs = operateLogMapper.selectByExample(logExample);
        return  operateLogs;

    }

    @Override
    public int opedateLogAdd(OperateLog operateLog) {
        int insert = operateLogMapper.insertSelective(operateLog);
        return insert;
    }

    @Override
    public List<OperateLog> finLogsByUid(int operateUid) {

       OperateLogExample example=new OperateLogExample() ;
        OperateLogExample.Criteria criteria = example.createCriteria();
        List<Integer> ids=new ArrayList<>();
        ids.add(operateUid);
        criteria.andOperateUidIn(ids);
        List<OperateLog> operateLogs = operateLogMapper.selectByExample(example);
        return operateLogs;
    }

    @Override
    public EasyuiDataGridResult findAllPages(Integer page, Integer pageSize, String username) {



            EasyuiDataGridResult dataGridResult=new EasyuiDataGridResult();
            OperateLogExample logExample=new OperateLogExample();
        OperateLogExample.Criteria criteria1 = logExample.createCriteria();


            //创建查询条件对象
            if(!StringUtils.isEmpty(username)) {
                criteria1.andUnameLike("%"+username+"%");


            }
            //查询结果添加分页功能
            PageHelper.startPage(page,pageSize);
        List<OperateLog> operateLogs = operateLogMapper.selectByExample(logExample);

            PageInfo<OperateLog> pageInfo=new PageInfo<>(operateLogs);//分页后
            dataGridResult.setRows(operateLogs);//设置当前页结果集
            long total = pageInfo.getTotal();
            dataGridResult.setTotal(total);


        return dataGridResult;
    }


    @Override
    public EasyuiDataGridResult findAllPagesUid(int operateUid, Integer page, Integer pageSize, String username) {




        EasyuiDataGridResult dataGridResult=new EasyuiDataGridResult();
        OperateLogExample logExample=new OperateLogExample();
        OperateLogExample.Criteria criteria1 = logExample.createCriteria();


        //创建查询条件对象
        if(!StringUtils.isEmpty(username)) {
            criteria1.andUnameLike("%"+username+"%");


        }
        //查询结果添加分页功能
        PageHelper.startPage(page,pageSize);
        List<OperateLog> operateLogs = operateLogMapper.selectByExample(logExample);
        List<OperateLog> logs=new ArrayList<>();
        for(OperateLog l:operateLogs){
            if(l.getOperateUid()==operateUid){
                logs.add(l);
            }
        }

        PageInfo<OperateLog> pageInfo=new PageInfo<>(logs);//分页后
        dataGridResult.setRows(logs);//设置当前页结果集
        long total = pageInfo.getTotal();
        dataGridResult.setTotal(total);


        return dataGridResult;
    }

    @Override
    public EasyuiDataGridResult findAllPages(Integer page, Integer pageSize, String username, Date d1, Date d2) {


        EasyuiDataGridResult dataGridResult=new EasyuiDataGridResult();
        OperateLogExample logExample=new OperateLogExample();
        OperateLogExample.Criteria criteria1 = logExample.createCriteria();
        criteria1.andOperateTimeBetween(d1,d2);
        

      /*  //创建查询条件对象
        if(!StringUtils.isEmpty(username)) {
            criteria1.andUnameLike("%"+username+"%");


        }*/
        List<OperateLog> logs = operateLogMapper.selectByExample(logExample);
        List<OperateLog> logList=new ArrayList<>();
        for(OperateLog log:logs){
            if(log.getUname().contains(username)){
                logList.add(log);
            }
        }


        //查询结果添加分页功能
       PageHelper.startPage(page,pageSize);
       // List<OperateLog> operateLogs = operateLogMapper.selectByExample(logExample);

        PageInfo<OperateLog> pageInfo=new PageInfo<>(logList);//分页后
        dataGridResult.setRows(logList);//设置当前页结果集
        long total = pageInfo.getTotal();
        dataGridResult.setTotal(total);


        return dataGridResult;




    }
}
