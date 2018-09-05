package com.example.luca.prae_app.view.listeners;

import android.content.Intent;
import android.view.View;

import com.example.luca.prae_app.menu_pages.avisos.AvisosWebViewActivity;

public class AvisoLinkListener implements View.OnClickListener {

    private String url;

    public AvisoLinkListener(String url){

        this.url = url;

    }


    @Override
    public void onClick(View view) {

        Intent i = new Intent(view.getContext(),AvisosWebViewActivity.class);

        i.putExtra("url",this.url);

        view.getContext().startActivity(i);

    }

}
