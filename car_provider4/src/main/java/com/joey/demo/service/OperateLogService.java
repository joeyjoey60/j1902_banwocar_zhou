package com.joey.demo.service;

import com.joey.demo.vo.EasyuiDataGridResult;
import org.springframework.web.bind.annotation.PathVariable;
import pojo.OperateLog;

import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/7/12.
 */
public interface OperateLogService {
    public List<OperateLog> findAll();
    public  int opedateLogAdd(OperateLog operateLog);//添加
    public List<OperateLog> finLogsByUid(@PathVariable("uid") int operateUid);
    public EasyuiDataGridResult findAllPages(Integer page, Integer pageSize, String username);//分页查询
    public EasyuiDataGridResult findAllPages(Integer page, Integer pageSize, String username, Date d1,Date d2);//分页查询
    public EasyuiDataGridResult findAllPagesUid(@PathVariable("uid") int operateUid,Integer page, Integer pageSize, String username);//分页查询
}
