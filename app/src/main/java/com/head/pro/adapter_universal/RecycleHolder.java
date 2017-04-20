package com.head.pro.adapter_universal;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class RecycleHolder<T> extends RecyclerView.ViewHolder{

    /**
     * 用于存储当前item当中的View
     */
    private SparseArray<View> mViews;
    private Context context;

    public RecycleHolder(View itemView, Context context) {
        super(itemView);
        mViews = new SparseArray<View>();
        this.context=context;
    }

    public <T extends View> T findView(int ViewId) {
        View view = mViews.get(ViewId);
        //集合中没有，则从item当中获取，并存入集合当中
        if (view == null) {
            view = itemView.findViewById(ViewId);
            mViews.put(ViewId, view);
        }
        return (T) view;
    }

    public RecycleHolder setText(int viewId, String text) {
        TextView tv = findView(viewId);
        tv.setText(text);
        return this;
    }

    public RecycleHolder setText(int viewId, int text) {
        TextView tv = findView(viewId);
        tv.setText(text);
        return this;
    }

    public RecycleHolder setImageResource(int viewId, int ImageId) {
        ImageView image = findView(viewId);
        image.setImageResource(ImageId);
        return this;
    }

    public RecycleHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView image = findView(viewId);
        image.setImageBitmap(bitmap);
        return this;
    }

    public RecycleHolder setImageNet(int viewId, String url) {
        ImageView image = findView(viewId);
        //使用你所用的网络框架等
//        ImageUtils.displayImageUseDefOptions(url, image);
        if (url != null && !"".equals(url)) {
          //  Picasso.with(context).load(url).placeholder(R.drawable.no_img).error(R.drawable.no_img).into(image);
           Glide.with(context).load(url).into(image);
        //    image.setImageURI(url);
        }
        return this;
    }
}
