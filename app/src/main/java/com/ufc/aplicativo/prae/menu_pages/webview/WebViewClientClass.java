package com.ufc.aplicativo.prae.menu_pages.webview;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientClass extends WebViewClient {

    @Override
    public boolean  shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return super.shouldOverrideUrlLoading(view, request);
    }


}