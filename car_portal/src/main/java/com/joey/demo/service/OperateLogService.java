package com.joey.demo.service;

import com.joey.demo.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.OperateLog;

import java.util.List;

/**
 * Created by zhou on 2019/7/13.
 */
@FeignClient(value = "zhou-provider4")
public interface OperateLogService {
    @RequestMapping(value = "/ol/list",method = RequestMethod.POST)
    public List<OperateLog> findAllLogs();
    @RequestMapping("/ol/listuid")
    public  List<OperateLog> findAllLogsByUname(int uid);
    @RequestMapping("/ol/listpage")
    public EasyuiDataGridResult findAll2(UserBatchQuery batchQuery);
    @RequestMapping("/ol/listpageuid")
    public EasyuiDataGridResult findAll3Uid(OperatoLogBatchQuery batchQuery);
    @RequestMapping("/ol/add")
    public  int addOperateLog(OperateLog operateLog);
}
