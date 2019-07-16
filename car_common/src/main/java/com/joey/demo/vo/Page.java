package com.joey.demo.vo;

import lombok.Data;

/**
 * Created by zhou on 2019/7/11.
 */
@Data
public class Page {
    private  int page;
    private  int pageSize;

    public Page(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Page() {
    }
}
