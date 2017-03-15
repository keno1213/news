package com.appleking.news.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appleking.news.MainActivity;
import com.appleking.news.R;
import com.appleking.news.adapter.ContentAdapter;
import com.appleking.news.bean.NewsData;
import com.appleking.news.presenter.NewsPresents;
import com.appleking.news.view.INewsView;
import com.appleking.news.widget.RecycleViewDivider;

import java.util.List;

/**
 * Created by appleking on 2017/3/2.
 *
 */

public class TabLayoutFragment extends Fragment implements INewsView {
    public static String TABLAYOUT_FRAGMENT = "tab_fragment";

    private int type;
    private RecyclerView recyclerView;
    private NewsPresents presents;
    private ContentAdapter adapter;

    public static TabLayoutFragment newInstance(int type) {
        TabLayoutFragment fragment = new TabLayoutFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TABLAYOUT_FRAGMENT, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = (int) getArguments().getSerializable(TABLAYOUT_FRAGMENT);
            presents = new NewsPresents(this);
        }

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablayout, container, false);
        initView(view);
        return view;
    }


    protected void initView(View view) {
//        txt = (TextView) view.findViewById(R.id.tab_txt);
        recyclerView = (RecyclerView) view.findViewById(R.id.id_recyclerview);

        presents.refresh();



    }

    @Override
    public void loadMore(int page) {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void gotoDetailNews(String url) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public String getType() {
        return MainActivity.types[type-1];
    }

    @Override
    public void setItems(List<NewsData.ResultBean.DataBean> beans) {
        adapter = new ContentAdapter(beans,this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new RecycleViewDivider(getActivity(),LinearLayoutManager.VERTICAL,27, Color.parseColor("#55666666")));
        recyclerView.setAdapter(adapter);
    }
}
