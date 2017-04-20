package com.head.pro.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.head.pro.factory.FragmentFactory;
import com.head.pro.iview.IMainView;
import com.head.pro.presenter.MainPresenter;
import com.head.pro.R;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    @BindView(R.id.contentlayout)
    FrameLayout contentlayout;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    private MainPresenter mainPresenter;
    private FragmentManager fragmentManager;

//首页面
    //头条首页1111
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        fragmentManager=getSupportFragmentManager();
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.init();
    }

//    @Override
//    protected boolean showToolBarBack() {
//        return false;
//    }


    @Override
    public void initView() {
        ((RadioButton)radioGroup.getChildAt(0)).setChecked(true);
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contentlayout, FragmentFactory.getInstance().getFragmentById(R.id.main)).commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int viewid) {
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contentlayout, FragmentFactory.getInstance().getFragmentById(viewid)).commit();
            }
        });

    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadData(Object object) {

    }


}
