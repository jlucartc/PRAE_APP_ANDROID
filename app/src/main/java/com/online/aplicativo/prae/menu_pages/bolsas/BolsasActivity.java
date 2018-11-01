package com.online.aplicativo.prae.menu_pages.bolsas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.online.aplicativo.prae.R;
import com.online.aplicativo.prae.menu_pages.auxilios.ajudaDeCusto.AjudaDeCustoActivity;
import com.online.aplicativo.prae.menu_pages.bolsas.BIA.BIAActivity;
import com.online.aplicativo.prae.menu_pages.bolsas.BID.BIDActivity;

public class BolsasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolsas);
    }

    public void bia(View v){

        Intent intent = new Intent(this,BIAActivity.class);
        startActivity(intent);

    }

    public void bid(View v){

        Intent intent = new Intent(this,BIDActivity.class);
        startActivity(intent);

    }

}
