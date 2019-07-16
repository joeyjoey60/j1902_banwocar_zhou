package com.joey.demo.vo;

import lombok.Data;

/**
 * Created by zhou on 2019/7/12.
 */
@Data
public class UserBatchQuery {
    private  int page;
    private  int pageSize;
    private  String username;

    @Override
    public String toString() {
        return "UserBatchQuery{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", username='" + username + '\'' +
                '}';
    }

    public UserBatchQuery() {
    }

    public UserBatchQuery(int page, int pageSize, String username) {
        this.page = page;
        this.pageSize = pageSize;
        this.username = username;
    }
}
