package com.head.pro.adapter_universal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;


public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<RecycleHolder> {

    public static final int TYPE_NORMAL = 1;
    private static final int TYPE_FOOTER = 2;
    private Context mContext;
    private List<T> mDatas;
    private int mLayoutId;
    private LayoutInflater mInflater;

    private OnItemClickListener onItemClickListener;
    private  static boolean isfootb=true;
    public RecyclerAdapter(Context mContext, List<T> mDatas, int mLayoutId) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.mLayoutId = mLayoutId;
        mInflater = LayoutInflater.from(mContext);
    }


    public void onDateChange(List<T> mDatas) {
        this.mDatas=mDatas;
        notifyDataSetChanged();
    }
    public T getItem(int position) {
        return mDatas.get(position);
    }
//    @Override
//    public int getItemViewType(int position) {
////        if (position + 1 == getItemCount())  return TYPE_FOOTER;
//        return TYPE_NORMAL;
//    }

    @Override
    public  RecycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if(viewType==TYPE_NORMAL){
            return new  RecycleHolder(mInflater.inflate(mLayoutId, parent, false),mContext);
//        }else{
//            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot, parent, false);
//                  RecycleHolder layout = new RecycleHolder(mInflater.inflate(R.layout.item_foot, parent, false));
//            return new FootViewHolder(layout);
//            return new RecycleHolder(mInflater.inflate(R.layout.item_foot, parent, false));
//        }
    }

    @Override
    public void onBindViewHolder(final RecycleHolder holder, int position) {
        convert(holder, mDatas.get(position), position);
        if (onItemClickListener != null) {
            //设置背景
            Log.i("TAG","点击");
          //  holder.itemView.setBackgroundResource(R.drawable.me_nor);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //注意，这里的position不要用上面参数中的position，会出现位置错乱\
                    onItemClickListener.OnItemClickListener(holder.itemView, holder.getLayoutPosition());
                }
            });
        }

    }
    public void onShowFootView(boolean footb){
        this.isfootb=footb;
    }

     class FootViewHolder extends RecyclerView.ViewHolder {
        public FootViewHolder(View view) {
            super(view);
            if(isfootb){
                view.setVisibility(View.VISIBLE);
            }else{
                view.setVisibility(View.GONE);
            }
        }
    }
    public abstract void convert( RecycleHolder holder, T data, int position);

    @Override
    public int getItemCount() {
        return mDatas==null? 0:mDatas.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public    interface OnItemClickListener {
          void OnItemClickListener(View view, int position);
    }
}
