package com.appleking.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by appleking on 2017/3/15.
 */

public class DetailPageActivity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        web = (WebView) findViewById(R.id.mWeb);
        String url = getIntent().getStringExtra("url");
        web.loadUrl(url);
    }
}
