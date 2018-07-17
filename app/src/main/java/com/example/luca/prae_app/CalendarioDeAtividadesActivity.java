package com.example.luca.prae_app;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

public class CalendarioDeAtividadesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_de_atividades);

        getSupportActionBar().setTitle("Calendário de atividades");

    }

}
