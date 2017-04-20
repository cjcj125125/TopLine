package com.head.pro.ui.fragment;


import android.util.Log;

import com.head.pro.R;
import com.head.pro.iview.IStoreFragmentView;
import com.head.pro.presenter.StorePresenter;


public class StoreFragment extends  BaseFragment<StorePresenter> implements IStoreFragmentView {


    public StoreFragment() {
        // Required empty public constructor
    }

    public static StoreFragment newInstance() {
        StoreFragment fragment = new StoreFragment();
        return fragment;
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_store;
    }

    @Override
    protected void initPresenter() {
        presenter = new StorePresenter(getActivity(), this);
        presenter.init();

    }

    @Override
    public void initView() {
        presenter.getData(-1);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadData(Object object) {
        Log.i("TAG", "接收到所有集合数据-----" + object.toString());
    }
}
