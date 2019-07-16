package com.joey.demo.vo;

import lombok.Data;

/**
 * Created by zhou on 2019/7/12.
 */
@Data
public class OperatoLogBatchQuery {
    private int uid;
    private  int page;
    private  int pageSize;
    private  String username;

    @Override
    public String toString() {
        return "OperatoLogBatchQuery{" +
                "uid=" + uid +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", username='" + username + '\'' +
                '}';
    }

    public OperatoLogBatchQuery() {
    }

    public OperatoLogBatchQuery(int uid, int page, int pageSize, String username) {
        this.uid = uid;
        this.page = page;
        this.pageSize = pageSize;
        this.username = username;
    }

    public OperatoLogBatchQuery(int page, int pageSize, String username) {
        this.page = page;
        this.pageSize = pageSize;
        this.username = username;
    }
}
