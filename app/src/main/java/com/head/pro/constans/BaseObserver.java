package com.head.pro.constans;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;


import com.head.pro.entity.BaseEntity;
import com.head.pro.widget.LoadDialog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Jie on 2017/4/8.
 */

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {
    private Context context;
    private Disposable disposable;
    private LoadDialog dialog;//等待的dialog

    public BaseObserver(Context context, LoadDialog dialog) {
        this.context = context;
        this.dialog=dialog;
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                disposable.dispose();//取消之后就不请求了
                //Disposable是1.x的Subscription改名的，因为Reactive-Streams规范用这个名称，为了避免重复
                //这个回调方法是在2.0之后新添加的
                //可以使用d.dispose()方法来取消订阅
            }
        });
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.disposable = d;
    }

    @Override
    public void onNext(BaseEntity<T> value) {
        if (value.getSuccess()) {
            //成功
            onSuccess(value.getData());
        } else {
            //失败
            onError(value.getCode(),value.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        if(dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
        Toast.makeText(context, "网络异常，请稍后再试", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onComplete() {
        if(dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
    }
    public abstract  void onSuccess(T t);

    public void onError(int code,String msg){
        Toast.makeText(context,msg+"---"+code, Toast.LENGTH_LONG).show();
    }


}
