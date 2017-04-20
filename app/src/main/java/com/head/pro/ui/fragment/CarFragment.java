package com.head.pro.ui.fragment;


import com.head.pro.R;

public class CarFragment extends BaseFragment {


    public CarFragment() {
        // Required empty public constructor
    }

    public static CarFragment newInstance() {
        CarFragment fragment = new CarFragment();
        return fragment;
    }



    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_car;
    }

    @Override
    protected void initPresenter() {

    }

}
