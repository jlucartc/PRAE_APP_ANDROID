package com.ufc.aplicativo.prae.menu_pages.voce_sabia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.menu_pages.webview.WebViewActivity;
import com.ufc.aplicativo.prae.view.adapters.SlidesAdapter;

public class VoceSabiaActivity extends AppCompatActivity {

    /*
    *
    * viewPager -> View que irá suportar a iteração através de slides.
    * adapter -> adaptador que ira determinar como os slides serão construídos e destruídos.
    *
    * */

    private ViewPager viewPager;

    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_layout);

        // Esconde a barra superior
        //getSupportActionBar().hide();


        /*
        *   Configura o Adapter dos slides e o adiciona ao ViewPager
        *   da view desta Activity
        *
        * */
        this.viewPager = (ViewPager)findViewById(R.id.slidesViewPager);
        this.adapter = new SlidesAdapter(this.getApplicationContext());
        this.viewPager.setAdapter(this.adapter);

    }

    /*
    *
    *   Função responsável por acionar a WebView que acessa os links
    *   dos slides.
    *
    * */

    public void linkParaSite(View v){

        Intent i = new Intent(v.getContext(),WebViewActivity.class);

        i.putExtra("url","http://prae.ufc.br");

        startActivity(i);

    }

}
