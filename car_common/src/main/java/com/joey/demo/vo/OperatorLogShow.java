package com.joey.demo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhou on 2019/7/12.
 */
@Data
public class OperatorLogShow implements Serializable {
   // private Long id;
    private  String uname;

    private Date optime;
    private  long id;


    private String tablename;//ip
    private String operateDesc;

    @Override
    public String toString() {
        return "OperatorLogShow{" +
                "uname='" + uname + '\'' +
                ", optime=" + optime +
                ", id=" + id +
                ", tablename='" + tablename + '\'' +
                ", operateDesc='" + operateDesc + '\'' +
                '}';
    }

    public OperatorLogShow(String uname, Date optime, long id, String tablename, String operateDesc) {
        this.uname = uname;
        this.optime = optime;
        this.id = id;
        this.tablename = tablename;
        this.operateDesc = operateDesc;
    }

    public OperatorLogShow() {
    }
}
