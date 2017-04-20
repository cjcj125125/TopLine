package com.head.pro.presenter;

import android.content.Context;

import com.head.pro.iview.IBaseView;
import com.head.pro.widget.LoadDialog;


/**
 * Created by Jie on 2017/2/12.
 * 基础Presenter
 */

public abstract class BasePresenter<T extends IBaseView> {
    protected LoadDialog dialog;//加载中的对话框
    protected Context context;
    protected T iview;
    public BasePresenter(Context context,T iview){
        this.context=context;
        this.iview=iview;
        dialog=new LoadDialog(context);
    }
    public void init(){
        iview.initView();
        iview.setListener();
    }

   // public abstract void release();

}
