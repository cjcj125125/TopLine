package com.head.pro.iview;

/**
 * Created by Jie on 2017/2/12.
 */
/***
 * 这里面定义一些操作view的方法
 * */
public interface IBaseView {
    /***
     * 初始化视图
     * */
    void initView();
    /**
     * 事件监听
     * */
    void setListener();
    /***
     *
     * 获取数据
     * */
    void loadData(Object object);
}
