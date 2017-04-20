package com.head.pro.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Right on 2017/4/20.
 */

public class Advertisement implements Serializable{

    /**
     * id : 25
     * createdAt : 1492070537000
     * updatedAt : 1492070537000
     * status : 1
     * sort : 1
     * title : 第三张图片
     * advImg : http://img02.tooopen.com/images/20140504/sy_60294738471.jpg
     * advLink : http://blog.csdn.net/u013218587/article/details/54646203
     */
    private int id;
    private Date createdAt;
    private Date updatedAt;
    private int status;
    private int sort;
    private String title;
    private String advImg;
    private String advLink;

    public Advertisement() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAdvImg(String advImg) {
        this.advImg = advImg;
    }

    public void setAdvLink(String advLink) {
        this.advLink = advLink;
    }

    public int getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public int getSort() {
        return sort;
    }

    public String getTitle() {
        return title;
    }

    public String getAdvImg() {
        return advImg;
    }

    public String getAdvLink() {
        return advLink;
    }
}
