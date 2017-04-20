package com.head.history;

import android.content.Context;

import com.head.pro.iview.IMainFragmentView;
import com.head.pro.presenter.BasePresenter;


/**
 * Created by Jie on 2017/2/16.
 */
public class RequestPresenter extends BasePresenter<IMainFragmentView> {

    public RequestPresenter(final Context context, IMainFragmentView iview) {
        super(context, iview);
    }
    public void getCommendList() {
System.out.print("啊哈");

        /***
         * 而如果我们想跟RxJava结合，这里的返回值对象就应该为Observable，
         * Observable的泛型这里为BaseEntity<User>，这个在上面的博客中也讲过，这里再说明下
         * **/
//        ConnectClient.getApiContent(ApiService.class).getCategoryList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Object>() {
//                    @Override
//                    public void accept(Object o) throws Exception {
//                        Log.i("TAG", "请求数据返回----成功1111111--" + o);
//                        // iview.getRecommend(o);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        Log.i("TAG", "请求失败--");
//                    }
//                });

//        NetServices.init(ApiService.class).getCategoryList().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Object>() {
//            @Override
//            public void accept(Object object) throws Exception {
//                List<RecommBean>recommBeanList= JSON.parseArray(object.toString(),RecommBean.class);
//                Log.i("TAG", "请求2222--" +object);
//                iview.loadData(recommBeanList);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                Log.i("TAG", "请求失败---" + throwable.toString());
//            }
//        });
        /**建议使用
        NetServices.init(ApiService.class).getCategoryList()
                .compose(new BaseObservableTransformer<BaseEntity<List<RecommBean>>>(context, dialog, true))
                .subscribe(new BaseObserver<List<RecommBean>>(context, dialog) {
                    @Override
                    public void onSuccess(List<RecommBean> list) {
                        if(list==null)return;
                        //List<RecommBean>recommBeanList= JSON.parseArray(str,RecommBean.class);
                        Log.i("TAG", "请求2222--" +list.toArray().toString());
                        iview.loadData(list);
                    }
                });

/***
 *在直接使用Retrofit，不使用RxJava时，我们的返回值都是Call
 * **/
//        Call<Object> call = ConnectNet.getInstance().create(ApiService.class).getRecommends();
//        call.enqueue(new Callback<Object>() {
//            @Override
//            public void onResponse(Call<Object> call, Response<Object> response) {
//                Log.i("TAG", "请求数据返回----成功2222222--" + response.body());
//                // iview.getData(response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<Object> call, Throwable t) {
//                Log.i("TAG", "请求失败------------");
//            }
//        });

    }
}
