package com.head.pro.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Right on 2017/4/20.
 */

public class Article implements Serializable {
    /**
     * id : 20
     * createdAt : 1490703253000
     * updatedAt : 1490853773000
     * status : 1
     * adminId : 5201314
     * accountId : 5201314
     * title : 1
     * marks : 2
     * comments : 0
     * collects : 0
     * auther : 1
     * img : 1
     * link : 1
     */
    private int id;
    private Date createdAt;
    private Date updatedAt;
    private int status;
    private int adminId;
    private int accountId;
    private String title;
    private int marks;
    private int comments;
    private int collects;
    private String auther;
    private String img;
    private String link;

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

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setCollects(int collects) {
        this.collects = collects;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setLink(String link) {
        this.link = link;
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

    public int getAdminId() {
        return adminId;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getTitle() {
        return title;
    }

    public int getMarks() {
        return marks;
    }

    public int getComments() {
        return comments;
    }

    public int getCollects() {
        return collects;
    }

    public String getAuther() {
        return auther;
    }

    public String getImg() {
        return img;
    }

    public String getLink() {
        return link;
    }
}
