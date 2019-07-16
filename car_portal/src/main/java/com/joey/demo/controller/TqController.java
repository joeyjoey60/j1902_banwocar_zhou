package com.joey.demo.controller;

import com.joey.demo.service.TqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
@Controller
public class TqController {
    @Autowired
    private TqService tqService;
    @RequestMapping("/page11")
    @ResponseBody
    public String page(){

        return tqService.page();

    }
}
