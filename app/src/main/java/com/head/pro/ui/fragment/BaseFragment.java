package com.head.pro.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.head.pro.presenter.BasePresenter;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * Created by Jie on 2017/2/12.
 */

public abstract class BaseFragment<T extends BasePresenter> extends RxFragment {
    protected  T presenter;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
       if(rootView==null){
           rootView=inflater.inflate(getLayoutResId(),container,false);
           ButterKnife.bind(this,rootView);
       }
        else{
           ViewGroup viewGroup= (ViewGroup) rootView.getParent();
           if(viewGroup!=null){
               viewGroup.removeView(rootView);
           }
       }
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPresenter();
    }
    /****
     * 初始化视图
     * */
    protected  abstract int getLayoutResId();
    protected  abstract void initPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.bind(getActivity()).unbind();
    }
}
