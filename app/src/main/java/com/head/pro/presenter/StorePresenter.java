package com.head.pro.presenter;

import android.content.Context;

import com.head.pro.iview.IStoreFragmentView;

/**
 * Created by Jie on 2017/2/21.
 */

public class StorePresenter extends  BasePresenter<IStoreFragmentView> {

    public StorePresenter(Context context, IStoreFragmentView iview) {
        super(context, iview);
    }
    public void getData(int parentId){
//        Call<Object>call= ConnectNet.getInstance().create(ApiService.class).getAllList(parentId);
//        call.enqueue(new Callback<Object>() {
//            @Override
//            public void onResponse(Call<Object> call, Response<Object> response) {
//                iview.loadData(response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<Object> call, Throwable t) {
//                Log.i("TAG","加载失败----");
//            }
//        });


    }
}
