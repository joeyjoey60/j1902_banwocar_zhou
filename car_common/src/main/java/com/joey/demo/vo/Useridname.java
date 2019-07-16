package com.joey.demo.vo;

import lombok.Data;

/**
 * Created by zhou on 2019/7/13.
 */
@Data
public class Useridname {
    private  int uid;
    private  String uname;

    @Override
    public String toString() {
        return "Useridname{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                '}';
    }

    public Useridname() {
    }

    public Useridname(int uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }
}
