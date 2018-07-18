package com.example.luca.prae_app.menu_pages.bolsas_auxilios;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.example.luca.prae_app.R;

public class BolsasAuxiliosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolsas_auxilio);

        getSupportActionBar().setTitle("Bolsas e auxílios");

    }

}
