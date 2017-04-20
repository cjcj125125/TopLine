package com.head.pro.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;


import com.head.pro.adapter_universal.RecyclerAdapter;
import com.head.pro.entity.Advertisement;
import com.head.pro.entity.Article;
import com.head.pro.entity.Pager;
import com.head.pro.iview.IMainFragmentView;
import com.head.pro.presenter.MainFragmentPresenter;
import com.head.pro.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;


public class MainFragment extends  BaseFragment<MainFragmentPresenter> implements IMainFragmentView {

    @BindView(R.id.xRecyclerView)
    XRecyclerView xRecyclerView;
    /**
     *文章列表适配器
     * */
    private RecyclerAdapter<Pager<List<Article>>> recyclerAdapter;

    public MainFragment() {
        // Required empty public constructor
    }
//    public static MainFragment newInstance() {
//        MainFragment fragment = new MainFragment();
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {}
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initPresenter() {
        presenter = new MainFragmentPresenter(getActivity(), this);
        presenter.init();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void initView() {
        presenter.getArticleList();//获取文章列表
        presenter.getAdvList();//获取广告
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void setListener() {
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "刷新", Toast.LENGTH_LONG).show();
                presenter.getArticleList();
                //  xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getContext(), "加载", Toast.LENGTH_LONG).show();
                presenter.getArticleList();
                //  xRecyclerView.loadMoreComplete();
            }
        });


    }

    @Override
    public void loadData(Object object) {
        xRecyclerView.refreshComplete();
        xRecyclerView.loadMoreComplete();
//        recyclerAdapter = new RecyclerAdapter<Pager<List<Article>>>(getActivity(), (Pager<List<Article>>) (object), android.R.layout.simple_list_item_1) {
//            @Override
//            public void convert(RecycleHolder holder, Pager<List<Article>> data, int position) {
//               // holder.setText(android.R.id.text1, data.getName());
//            }
//        };
//        xRecyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void loadAdvertisement(List<Advertisement> advertisementList) {
        Log.i("TAG","广告列表大小"+advertisementList.size());
    }
}
