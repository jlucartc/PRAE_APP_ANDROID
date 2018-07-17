package com.example.luca.prae_app;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

public class MapaDaPraeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_da_prae);

        getSupportActionBar().setTitle("Mapa da PRAE");

    }

}
