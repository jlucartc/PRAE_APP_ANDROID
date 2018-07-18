package com.example.luca.prae_app.menu_pages.restaurante_universitario;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.example.luca.prae_app.R;

public class RestauranteUniversitarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_universitario);

        getSupportActionBar().setTitle("Restaurante Universitário");

    }

}
