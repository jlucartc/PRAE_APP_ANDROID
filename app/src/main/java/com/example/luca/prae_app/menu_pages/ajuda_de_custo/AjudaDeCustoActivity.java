package com.example.luca.prae_app.menu_pages.ajuda_de_custo;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.example.luca.prae_app.R;

public class AjudaDeCustoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda_de_custo);

        getSupportActionBar().setTitle("Ajuda de custo");

    }

}
