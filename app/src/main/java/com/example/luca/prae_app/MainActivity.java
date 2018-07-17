package com.example.luca.prae_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

public class MainActivity extends AppCompatActivity {

    private Button noticiasButton;
    private WorkRequest atualizarNoticias;
    private UUID atualizarNoticiasId;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity","MainActivity foi executada");

        this.gson = new Gson();

        this.sharedPreferences = this.getSharedPreferences("com.example.luca.prae_app",Context.MODE_PRIVATE);

        this.atualizarNoticiasId = gson.fromJson(this.sharedPreferences.getString("atualizarNoticiasUUID",""),UUID.class);

        Log.i("isJsonNull",String.valueOf(this.atualizarNoticiasId == null));

        if(this.atualizarNoticiasId == null){

            this.atualizarNoticias = new PeriodicWorkRequest.Builder(AtualizarNoticias.class,15,TimeUnit.MINUTES).build();

            WorkManager.getInstance().enqueue(atualizarNoticias);

            SharedPreferences.Editor editor = this.sharedPreferences.edit();

            editor.putString("atualizarNoticiasUUID",this.gson.toJson(this.atualizarNoticias.getId()));

            editor.commit();
        }

    }

    public void noticias(View view){

        Intent intent = new Intent(this,NoticiasActivity.class);
        startActivity(intent);
    }


    public void ajudaDeCusto(View view){

        Intent intent = new Intent(this,AjudaDeCustoActivity.class);
        startActivity(intent);

    }

    public void bolsasAuxilios(View view){

        Intent intent = new Intent(this,BolsasAuxiliosActivity.class);
        startActivity(intent);

    }

    public void restauranteUniversitario(View view){

        Intent intent = new Intent(this,RestauranteUniversitarioActivity.class);
        startActivity(intent);

    }

    public void acolhimentoAoEstudante(View view){

        Intent intent = new Intent(this,AcolhimentoAoEstudanteActivity.class);
        startActivity(intent);

    }

    public void calendarioDeAtividades(View view){

        Intent intent = new Intent(this,CalendarioDeAtividadesActivity.class);
        startActivity(intent);

    }

    public void mapaDaPrae(View view){

        Intent intent = new Intent(this,MapaDaPraeActivity.class);
        startActivity(intent);

    }

    public void voceSabia(View view){

        Intent intent = new Intent(this,VoceSabiaActivity.class);
        startActivity(intent);

    }

    public void faleConosco(View view){

        Intent intent = new Intent(this,FaleConoscoActivity.class);
        startActivity(intent);

    }



}
