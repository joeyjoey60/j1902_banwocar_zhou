package com.joey.demo.controller;

import com.joey.demo.service.OperateLogService;
import com.joey.demo.vo.EasyuiDataGridResult;
import com.joey.demo.vo.OperatoLogBatchQuery;
import com.joey.demo.vo.OperatoLogBatchQueryLike;
import com.joey.demo.vo.UserBatchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.OperateLog;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/7/12.
 */
@Controller
public class OperatorLogController {
    @Autowired
    private OperateLogService operateLogService;

    @RequestMapping(value = "/ol/add",method = RequestMethod.POST)
    @ResponseBody
    public  int addOperateLog(@RequestBody OperateLog operateLog){
        int i = operateLogService.opedateLogAdd(operateLog);
        return  i;
    }

    @RequestMapping(value = "/ol/list",method = RequestMethod.POST)
    @ResponseBody
    public  List<OperateLog> findAllLogs(){
        List<OperateLog> all = operateLogService.findAll();
        return  all;
    }


    @RequestMapping(value = "/ol/listuid",method = RequestMethod.POST)
    @ResponseBody
    public  List<OperateLog> findAllLogsByUname(@RequestBody int uid){
        System.out.println(uid+"uid");
        List<OperateLog> all = operateLogService.finLogsByUid(uid);
        return  all;
    }
    @RequestMapping(value = "/ol/page",method = RequestMethod.POST)
    @ResponseBody
    public  String olpage(HttpServletRequest request){
        String uname = (String)request.getSession().getAttribute("uname");
        uname=uname+"mmmm";
        return  uname;
    }
  /*  @RequestMapping(value = "/ol/list",method = RequestMethod.POST)
    @ResponseBody
    public EasyuiDataGridResult findAll(Page page){


    }*/

    @RequestMapping("/ol/listpage")
    @ResponseBody
    public EasyuiDataGridResult findAll2(@RequestBody OperatoLogBatchQueryLike batchQuery){
        int page=batchQuery.getPage();
        int pageSize=batchQuery.getPageSize();
        String username=batchQuery.getUsername();
        Date d1 = batchQuery.getD1();
        Date d2 = batchQuery.getD2();


        EasyuiDataGridResult allPages = operateLogService.findAllPages(page, pageSize, username);
        return  allPages;

    }
    @RequestMapping("/ol/listpageuid")
    @ResponseBody
    public EasyuiDataGridResult findAll3Uid(@RequestBody OperatoLogBatchQuery batchQuery){
        int page=batchQuery.getPage();
        int pageSize=batchQuery.getPageSize();
        String username=batchQuery.getUsername();
        int uid = batchQuery.getUid();
        EasyuiDataGridResult allPagesUid = operateLogService.findAllPagesUid(uid, page, pageSize, username);
        return  allPagesUid;
    }


}
