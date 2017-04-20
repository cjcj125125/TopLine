package com.head.pro.ui.fragment;


import com.head.pro.R;

public class MySelfFragment extends BaseFragment {


    public MySelfFragment() {
        // Required empty public constructor
    }

    public static MySelfFragment newInstance() {
        MySelfFragment fragment = new MySelfFragment();
        return fragment;
    }



    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initPresenter() {

    }

}
