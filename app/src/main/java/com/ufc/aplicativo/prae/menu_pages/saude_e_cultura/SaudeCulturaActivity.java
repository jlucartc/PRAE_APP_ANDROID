package com.ufc.aplicativo.prae.menu_pages.saude_e_cultura;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.menu_pages.saude_e_cultura.comunicacao.comunicacaoActivity;
import com.ufc.aplicativo.prae.menu_pages.saude_e_cultura.cultura.culturaActivity;
import com.ufc.aplicativo.prae.menu_pages.saude_e_cultura.educacao.educacaoActivity;
import com.ufc.aplicativo.prae.menu_pages.saude_e_cultura.meioAmbiente.meioAmbienteActivity;
import com.ufc.aplicativo.prae.menu_pages.saude_e_cultura.saude.saudeActivity;

public class SaudeCulturaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude_cultura);
    }

    public void comunicacao(View v){

        Intent intent = new Intent(this, comunicacaoActivity.class);
        startActivity(intent);

    }

    public void cultura(View v){

        Intent intent = new Intent(this, culturaActivity.class);
        startActivity(intent);

    }

    public void educacao(View v){

        Intent intent = new Intent(this, educacaoActivity.class);
        startActivity(intent);

    }

    public void meioAmbiente(View v){

        Intent intent = new Intent(this, meioAmbienteActivity.class);
        startActivity(intent);

    }

    public void saude(View v){

        Intent intent = new Intent(this, saudeActivity.class);
        startActivity(intent);

    }
}
