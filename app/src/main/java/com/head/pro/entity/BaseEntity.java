package com.head.pro.entity;

import java.io.Serializable;

/**
 * Created by Jie on 2017/4/8.
 */

public class BaseEntity<E> implements Serializable {
    /**
     * 返回标识
     */
    private int code;
    /**
     * 成功或失败的提示
     */
    private String msg;
    /**
     * 数据
     **/
   private E data;
/***
 * 是否成功
 * **/
private Boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
