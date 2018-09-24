package com.example.luca.prae_app.menu_pages.voce_sabia;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.menu_pages.webview.WebViewActivity;

public class VoceSabiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voce_sabia);

        getSupportActionBar().setTitle("Você Sabia?");

    }

    public void linkParaSite(View v){

        Intent i = new Intent(v.getContext(),WebViewActivity.class);

        i.putExtra("url","http://prae.ufc.br");

        startActivity(i);

    }

}
