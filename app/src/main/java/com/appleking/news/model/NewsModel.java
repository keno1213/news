package com.appleking.news.model;

import com.appleking.news.bean.NewsData;
import com.appleking.news.presenter.NewsPresents;
import com.appleking.news.service.NewService;
import com.appleking.news.utils.RetrofitWrapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by appleking on 2017/3/14.
 */

public class NewsModel implements INewsModel {
    @Override
    public NewsData loadData(String type) {
        NewService service = RetrofitWrapper.getInstance().create(NewService.class);
        Call<NewsData> call = service.getNewsData("82ec1eb5afb7c26d8d9a88c3be20bf43", type);
        call.enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {

            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {

            }
        });
        return null;
    }
}
