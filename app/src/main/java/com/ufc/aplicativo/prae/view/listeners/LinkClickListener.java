package com.ufc.aplicativo.prae.view.listeners;

import android.content.Intent;
import android.view.View;

import com.ufc.aplicativo.prae.menu_pages.webview.WebViewActivity;

public class LinkClickListener implements View.OnClickListener {

    private String url;

    public LinkClickListener(String url){

        this.url = url;

    }


    @Override
    public void onClick(View view) {

        Intent i = new Intent(view.getContext(),WebViewActivity.class);

        i.putExtra("url",this.url);

        view.getContext().startActivity(i);

    }

}
