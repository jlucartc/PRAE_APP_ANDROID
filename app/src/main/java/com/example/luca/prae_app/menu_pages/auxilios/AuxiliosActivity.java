package com.example.luca.prae_app.menu_pages.auxilios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.menu_pages.auxilios.ajudaDeCusto.AjudaDeCustoActivity;
import com.example.luca.prae_app.menu_pages.auxilios.auxilioCreche.AuxilioCrecheActivity;
import com.example.luca.prae_app.menu_pages.auxilios.auxilioEmergencial.AuxilioEmergencialActivity;
import com.example.luca.prae_app.menu_pages.auxilios.auxilioMoradia.AuxilioMoradiaActivity;
import com.example.luca.prae_app.menu_pages.auxilios.isencaoDoRU.IsencaoDoRUActivity;

public class AuxiliosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_auxilios);

    }

    public void ajudaDeCusto(View v){

        Intent intent = new Intent(this,AjudaDeCustoActivity.class);
        intent.putExtra("tipo",2);
        startActivity(intent);

    }

    public void auxilioCreche(View v){

        Intent intent = new Intent(this,AuxilioCrecheActivity.class);
        startActivity(intent);

    }

    public void auxilioEmergencial(View v){

        Intent intent = new Intent(this,AuxilioEmergencialActivity.class);
        startActivity(intent);

    }


    public void auxilioMoradia(View v){

        Intent intent = new Intent(this,AuxilioMoradiaActivity.class);
        startActivity(intent);

    }

    public void isencaoDoRU(View v){

        Intent intent = new Intent(this,IsencaoDoRUActivity.class);
        startActivity(intent);

    }

}
