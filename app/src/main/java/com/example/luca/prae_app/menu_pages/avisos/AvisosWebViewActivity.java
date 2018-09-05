package com.example.luca.prae_app.menu_pages.avisos;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.luca.prae_app.R;

public class AvisosWebViewActivity extends AppCompatActivity {

    private WebView webView;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        this.url = getIntent().getStringExtra("url");

        this.webView = (WebView)findViewById(R.id.webView);

        this.webView.getSettings().setBuiltInZoomControls(true);
        this.webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        this.webView.setBackgroundColor(Color.TRANSPARENT);
        this.webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_INSET);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        this.webView.getSettings().setAllowFileAccess(true);
        this.webView.setWebViewClient(new AvisosWebViewClient());
        this.webView.loadUrl(this.url);


    }


}
