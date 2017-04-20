package com.head.pro.presenter;

import android.content.Context;


import com.head.pro.constans.ApiService;
import com.head.pro.constans.BaseObservableTransformer;
import com.head.pro.constans.BaseObserver;
import com.head.pro.constans.ConnectNet;
import com.head.pro.entity.Advertisement;
import com.head.pro.entity.BaseEntity;
import com.head.pro.iview.IMainFragmentView;

import java.util.List;

/**
 * Created by Jie on 2017/2/16.
 */
public class MainFragmentPresenter extends BasePresenter<IMainFragmentView> {

    public MainFragmentPresenter(final Context context, IMainFragmentView iview) {
        super(context, iview);
    }
    /***
     * 文章列表
     * */
    public void getArticleList() {

    }
    /**
     * 获取广告列表
     * */
    public void getAdvList(){
        ConnectNet.getInstance().create(ApiService.class).getAdvertisement()
                .compose(new BaseObservableTransformer<BaseEntity<List<Advertisement>>>(context,dialog,true))
                .subscribe(new BaseObserver<List<Advertisement>>(context,dialog) {
                    @Override
                    public void onSuccess(List<Advertisement> advertisementList) {
                        iview.loadAdvertisement(advertisementList);
                    }
                });
    }
}
