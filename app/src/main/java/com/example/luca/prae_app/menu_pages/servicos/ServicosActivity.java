package com.example.luca.prae_app.menu_pages.servicos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.menu_pages.auxilios.auxilioEmergencial.AuxilioEmergencialActivity;
import com.example.luca.prae_app.menu_pages.servicos.restauranteUniversitario.RestauranteUniversitarioActivity;

public class ServicosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_servicos);

    }

    public void residenciaUniversitaria(View v){

        Intent intent = new Intent(this,ResidenciaUniversitariaActivity.class);
        startActivity(intent);

    }

    public void restauranteUniversitario(View v){

        Intent intent = new Intent(this,RestauranteUniversitarioActivity.class);
        startActivity(intent);

    }

}
