package com.appleking.news.view;

import com.appleking.news.bean.NewsData;

import java.util.List;

/**
 * Created by appleking on 2017/3/14.
 */

public interface INewsView {
    void loadMore(int page);
    void refresh();
    void gotoDetailNews(String url);
    void showLoading();
    void showError();
    String getType();
    void setItems(List<NewsData.ResultBean.DataBean> beans);
}
