package com.appleking.news.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by appleking on 2017/3/16.
 */

public class NoLoadWebView extends WebView {
    public NoLoadWebView(Context context) {
        this(context,null);
    }

    public NoLoadWebView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NoLoadWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(false);

        setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(null);
                return true;
            }
        });
    }


}
