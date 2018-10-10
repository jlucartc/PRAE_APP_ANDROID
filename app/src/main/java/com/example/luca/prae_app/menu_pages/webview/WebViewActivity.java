package com.example.luca.prae_app.menu_pages.webview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.luca.prae_app.R;

public class WebViewActivity extends AppCompatActivity {

    /*
    *
    *  webView : elemento responsável por carregar o link acessado
    *  url : link a ser acessado pelo webView
    *
    * */

    private WebView webView;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        /*
        *  url e webView são setados
        *
        * */

        this.url = getIntent().getStringExtra("url");

        this.webView = (WebView)findViewById(R.id.webView);


        /*
        * Configura a WebView e apresenta o link
        *
        * */

        this.webView.getSettings().setBuiltInZoomControls(true);
        this.webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        this.webView.setBackgroundColor(Color.TRANSPARENT);
        this.webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_INSET);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        this.webView.getSettings().setAllowFileAccess(true);
        this.webView.setWebViewClient(new WebViewClient());
        this.webView.loadUrl(this.url);


    }

}
