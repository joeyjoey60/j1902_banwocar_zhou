package com.joey.demo.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhou on 2019/7/11.
 */
public class ExcepController {
    @ExceptionHandler(value=AuthorizationException.class)//标识需要拦截的异常
    public  String  defaultErrorHandler(HttpServletRequest request, Exception e){

        return "unauth";
    }
}
