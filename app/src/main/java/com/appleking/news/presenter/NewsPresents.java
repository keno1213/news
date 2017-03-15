package com.appleking.news.presenter;

import android.util.Log;

import com.appleking.news.bean.NewsData;
import com.appleking.news.model.INewsModel;
import com.appleking.news.model.NewsModel;
import com.appleking.news.service.NewService;
import com.appleking.news.utils.RetrofitWrapper;
import com.appleking.news.view.INewsView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by appleking on 2017/3/14.
 */

public class NewsPresents {
    private INewsView view;
    private INewsModel model;

    public NewsPresents(INewsView view) {
        this.view = view;
        this.model = new NewsModel();
    }

    public void refresh(){
        NewService service = RetrofitWrapper.getInstance().create(NewService.class);
        Call<NewsData> call = service.getNewsData("82ec1eb5afb7c26d8d9a88c3be20bf43", view.getType());
        call.enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {
                NewsData data = response.body();
                view.setItems(data.getResult().getData());
                Log.e("TAG","-----");
            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {
                view.showError();
            }
        });
    }
}
