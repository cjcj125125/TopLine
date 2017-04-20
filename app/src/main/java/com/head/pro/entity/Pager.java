package com.head.pro.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Right on 2017/4/20.
 */

public class Pager<T> implements Serializable {


    /**
     * totalCount : 12
     * currentPage : 1
     * totalPage : 2
     * pageSize : 10
     * data:T
     */
    private int totalCount;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private List<T>dataList;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }
}
