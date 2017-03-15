package com.appleking.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appleking.news.DetailPageActivity;
import com.appleking.news.R;
import com.appleking.news.bean.NewsData;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by appleking on 2017/3/8.
 */


public class ContentAdapter extends RecyclerView.Adapter {
    private List<NewsData.ResultBean.DataBean> mDatas;
    private Fragment context;
    public ContentAdapter(List<NewsData.ResultBean.DataBean> mDatas) {
        this.mDatas = mDatas;
    }

    public ContentAdapter(List<NewsData.ResultBean.DataBean> mDatas, Fragment context) {
        this.mDatas = mDatas;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_news,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.bindData(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        if (mDatas != null){
            return mDatas.size();
        }
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv;
        private TextView title;
        private TextView author;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_image);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            author = (TextView) itemView.findViewById(R.id.tv_author);

        }

        public void bindData(final NewsData.ResultBean.DataBean bean){
            Glide.with(context).load(bean.getThumbnail_pic_s()).into(iv);
            title.setText(bean.getTitle());
            author.setText(bean.getAuthor_name());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context.getActivity(), DetailPageActivity.class);
                    intent.putExtra("url",bean.getUrl());
                    context.startActivity(intent);
                }
            });
        }
    }
}
