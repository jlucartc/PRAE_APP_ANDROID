package com.example.luca.prae_app.menu_pages.voce_sabia;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.menu_pages.webview.WebViewActivity;

public class VoceSabiaActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_layout);

        getSupportActionBar().hide();

        this.viewPager = (ViewPager)findViewById(R.id.slidesViewPager);
        this.adapter = new SlidesAdapter();
        this.viewPager.setAdapter(this.adapter);

    }

    public void linkParaSite(View v){

        Intent i = new Intent(v.getContext(),WebViewActivity.class);

        i.putExtra("url","http://prae.ufc.br");

        startActivity(i);

    }

}
