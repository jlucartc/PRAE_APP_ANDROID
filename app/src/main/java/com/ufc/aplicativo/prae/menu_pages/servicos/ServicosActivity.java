package com.ufc.aplicativo.prae.menu_pages.servicos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.menu_pages.servicos.dae.DAEActivity;
import com.ufc.aplicativo.prae.menu_pages.servicos.residenciaUniversitaria.ResidenciaUniversitariaActivity;
import com.ufc.aplicativo.prae.menu_pages.servicos.restauranteUniversitario.RestauranteUniversitarioActivity;

public class ServicosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_servicos);


    }

    /*
    *
    * Aciona a Activity de residência universitária através de um botão presente
    * na view desta Activity.
    *
    * */

    public void residenciaUniversitaria(View v){

        Intent intent = new Intent(this,ResidenciaUniversitariaActivity.class);
        startActivity(intent);

    }

    /*
     *
     * Aciona a Activity de restaurante universitário através de um botão presente
     * na view desta Activity.
     *
     * */

    public void restauranteUniversitario(View v){

        Intent intent = new Intent(this,RestauranteUniversitarioActivity.class);
        startActivity(intent);

    }

    public void dae(View v){

        Intent intent = new Intent(this,DAEActivity.class);
        startActivity(intent);

    }

}
