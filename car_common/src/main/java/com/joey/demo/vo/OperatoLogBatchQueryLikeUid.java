package com.joey.demo.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by zhou on 2019/7/12.
 */
@Data
public class OperatoLogBatchQueryLikeUid {
    private int uid;
    private  int page;
    private  int pageSize;
    private  String username;
    private Date d1;
    private  Date d2;

    @Override
    public String toString() {
        return "OperatoLogBatchQueryLike{" +
                "uid=" + uid +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", username='" + username + '\'' +
                ", d1=" + d1 +
                ", d2=" + d2 +
                '}';
    }

    public OperatoLogBatchQueryLikeUid(int page, int pageSize, String username, Date d1, Date d2) {
        this.page = page;
        this.pageSize = pageSize;
        this.username = username;
        this.d1 = d1;
        this.d2 = d2;
    }

    public OperatoLogBatchQueryLikeUid(int uid, int page, int pageSize, String username, Date d1, Date d2) {
        this.uid = uid;
        this.page = page;
        this.pageSize = pageSize;
        this.username = username;
        this.d1 = d1;
        this.d2 = d2;
    }

    public OperatoLogBatchQueryLikeUid() {
    }

    public OperatoLogBatchQueryLikeUid(int uid, int page, int pageSize, String username) {
        this.uid = uid;
        this.page = page;
        this.pageSize = pageSize;
        this.username = username;
    }

    public OperatoLogBatchQueryLikeUid(int page, int pageSize, String username) {
        this.page = page;
        this.pageSize = pageSize;
        this.username = username;
    }
}
