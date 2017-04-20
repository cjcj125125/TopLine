package com.head.pro.constans;

import android.content.Context;


import com.head.pro.widget.LoadDialog;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jie on 2017/4/8.
 */

public class BaseObservableTransformer<T> implements ObservableTransformer<T, T> {
    private Context context;
    private String msg;//dialog上的提示文字
    private boolean hasDialog;
    private LoadDialog loadDialog;

    public BaseObservableTransformer(Context context,LoadDialog loadDialog, boolean hasDialog) {
        this.context = context;
        this.loadDialog=loadDialog;
        this.hasDialog = hasDialog;
    }

//    public BaseObservableTransformer(Context context) {
//        this(context, true);
//    }

    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (hasDialog) {
                            //显示dialog
                            if(msg!=null){
                                loadDialog.setLoadMsg(msg);
                            }
                            loadDialog.show();
                        }
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
