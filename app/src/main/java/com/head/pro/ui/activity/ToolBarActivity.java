package com.head.pro.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.animation.DecelerateInterpolator;

import com.head.pro.presenter.BasePresenter;
import com.head.pro.R;

import butterknife.BindView;

/**
 * Created by Jie on 2017/2/12.
 */

public abstract class ToolBarActivity<T extends BasePresenter> extends  BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar)
     AppBarLayout appBar;
    protected boolean toolbarhide = false;//ToolBar默认不显示

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showToolBarBack());//返回鍵
    }

    /***
     * ToorBar返回键
     **/
    protected abstract boolean showToolBarBack();

    public void hideOrshowToolBar() {
        appBar.animate().translationX(toolbarhide ? 0 : -appBar.getHeight())
                .setInterpolator(new DecelerateInterpolator(2)).start();
          toolbarhide = !toolbarhide;
    }
}
