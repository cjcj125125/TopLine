package com.head.pro.ui.activity;


import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.head.pro.presenter.BasePresenter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;


/**
 * Created by Jie on 2017/2/12.
 */

public abstract class BaseActivity<T extends BasePresenter> extends RxAppCompatActivity {
    protected String TAG = this.getClass().getSimpleName();
    protected T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        initPresenter();

    }
    /***
     * 绑定layout
     * */
    protected abstract int getLayoutResId();
    /***
     * 初始化操作
     * */
    protected abstract void initPresenter();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //在Action Bar的最左边，就是Home icon和标题的区域
                onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG","onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //MobclickAgent.onResume(this);//友盟
        Log.i("TAG","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.bind(this).unbind();
        Log.i("TAG","onDestroy");
    }
}
