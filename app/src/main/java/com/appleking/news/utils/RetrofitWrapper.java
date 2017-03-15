package com.appleking.news.utils;

import android.content.Context;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by appleking on 2017/3/14.
 *
 */

public class RetrofitWrapper {
    private static RetrofitWrapper instance;
    private Context mContext;
    private Retrofit retrofit;
    private RetrofitWrapper() {
        retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static RetrofitWrapper getInstance() {
        if (instance == null) {
            synchronized (RetrofitWrapper.class) {
                instance = new RetrofitWrapper();
            }
        }
        return instance;
    }

    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }

    public class Constant {
        public static final String BASE_URL = "http://v.juhe.cn";
    }
}
