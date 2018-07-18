package com.example.luca.prae_app.menu_pages.voce_sabia;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.example.luca.prae_app.R;

public class VoceSabiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voce_sabia);

        getSupportActionBar().setTitle("Você Sabia?");

    }

}
