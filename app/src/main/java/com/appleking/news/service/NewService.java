package com.appleking.news.service;

import com.appleking.news.bean.NewsData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by appleking on 2017/3/14.
 */

public interface NewService {
    @POST("/toutiao/index")
    Call<NewsData> getNewsData(@Query("key") String key,
                               @Query("type") String type);
}
