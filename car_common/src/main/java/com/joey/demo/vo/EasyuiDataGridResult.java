package com.joey.demo.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by zhou on 2019/7/11.
 */
@Data
public class EasyuiDataGridResult {
    private long  total;//总记录数
    private List<?> rows;//返回当前页结果集
}
