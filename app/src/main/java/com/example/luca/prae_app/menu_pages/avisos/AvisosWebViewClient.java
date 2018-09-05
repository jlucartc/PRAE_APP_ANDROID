package com.example.luca.prae_app.menu_pages.avisos;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AvisosWebViewClient extends WebViewClient {

    @Override
    public boolean  shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return super.shouldOverrideUrlLoading(view, request);
    }

}
