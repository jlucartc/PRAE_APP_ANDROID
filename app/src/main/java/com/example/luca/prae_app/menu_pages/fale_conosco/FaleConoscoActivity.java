package com.example.luca.prae_app.menu_pages.fale_conosco;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.example.luca.prae_app.R;

public class FaleConoscoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fale_conosco);

        getSupportActionBar().setTitle("Fale conosco");

    }

}