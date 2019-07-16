package com.joey.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
@FeignClient(value = "banwo-server")
public interface TqService {

    @RequestMapping("/index")
    public String page();





}
