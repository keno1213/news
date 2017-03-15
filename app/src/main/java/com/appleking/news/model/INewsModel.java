package com.appleking.news.model;

import com.appleking.news.bean.NewsData;

/**
 * Created by appleking on 2017/3/14.
 */

public interface INewsModel {
   NewsData loadData(String type);
}
