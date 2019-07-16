package com.joey.demo.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by zhou on 2019/7/10.
 */
@Data
public class MsgResult {
    private  Integer status;
    private  String message;
    private List<?> data;
}
