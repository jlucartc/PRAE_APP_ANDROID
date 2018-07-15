package com.example.luca.prae_app;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;

import java.net.URL;

public class NoticiaWebViewActivity extends Activity {

    private WebView webView;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        this.url = getIntent().getStringExtra("url");

        this.webView = (WebView)findViewById(R.id.noticiaWebView);

        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.loadUrl(url);
    }

}
