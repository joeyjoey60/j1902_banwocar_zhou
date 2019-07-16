package com.joey.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhou on 2019/7/16.
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String showindex(){
        return  "index";
    }
}
