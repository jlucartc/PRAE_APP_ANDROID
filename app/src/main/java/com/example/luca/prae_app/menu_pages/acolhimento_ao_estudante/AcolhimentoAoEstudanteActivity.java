package com.example.luca.prae_app.menu_pages.acolhimento_ao_estudante;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.example.luca.prae_app.R;

public class AcolhimentoAoEstudanteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acolhimento_ao_estudante);

        getSupportActionBar().setTitle("Acolhimento ao estudante");

    }

}
