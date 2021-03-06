package com.ufc.aplicativo.prae;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.ufc.aplicativo.prae.menu_pages.auxilios.AuxiliosActivity;
import com.ufc.aplicativo.prae.menu_pages.avisos.AvisosActivity;
import com.ufc.aplicativo.prae.menu_pages.bolsas.BolsasActivity;
import com.ufc.aplicativo.prae.menu_pages.calendario_de_atividades.CalendarioDeAtividadesActivity;
import com.ufc.aplicativo.prae.menu_pages.fale_conosco.FaleConoscoActivity;
import com.ufc.aplicativo.prae.menu_pages.mapa_da_prae.MapaDaPraeActivity;
import com.ufc.aplicativo.prae.menu_pages.noticias.NoticiasActivity;
import com.ufc.aplicativo.prae.menu_pages.notificacoes_por_email.NotificacoesPorEmailActivity;
import com.ufc.aplicativo.prae.menu_pages.servicos.ServicosActivity;
import com.ufc.aplicativo.prae.menu_pages.voce_sabia.VoceSabiaActivity;
import com.ufc.aplicativo.prae.workers.AtualizarDados;
import com.google.gson.Gson;

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

        //getSupportActionBar().setTitle("Aplicativo da PRAE");
        //getSupportActionBar().hide();

        Log.i("MainActivity","onCreate");

        this.gson = new Gson();

        this.sharedPreferences = this.getSharedPreferences("com.example.luca.prae_app",Context.MODE_PRIVATE);

        this.atualizarNoticiasId = gson.fromJson(this.sharedPreferences.getString("atualizarNoticiasUUID",""),UUID.class);

        //if(this.atualizarNoticiasId == null){

        this.atualizarNoticias = new PeriodicWorkRequest.Builder(AtualizarDados.class,15,TimeUnit.MINUTES).build();

        WorkManager.getInstance().enqueue(atualizarNoticias);

        SharedPreferences.Editor editor = this.sharedPreferences.edit();

        editor.putString("atualizarNoticiasUUID",this.gson.toJson(this.atualizarNoticias.getId()));

        editor.commit();
        //}

    }


    public void noticias(View view){

        Intent intent = new Intent(this,NoticiasActivity.class);
        startActivity(intent);
    }


    public void bolsas(View view){

        Intent intent = new Intent(this,BolsasActivity.class);
        intent.putExtra("tipo",1);
        startActivity(intent);

    }

    public void auxilios(View view){

        Intent intent = new Intent(this,AuxiliosActivity.class);
        intent.putExtra("tipo",2);
        startActivity(intent);

    }

    public void servicos(View view){

        Intent intent = new Intent(this,ServicosActivity.class);
        intent.putExtra("tipo",3);
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

    public void notificacoesPorEmail(View view){

        Intent intent = new Intent(this,NotificacoesPorEmailActivity.class);
        startActivity(intent);

    }

    public void avisos(View v){

        Intent intent = new Intent(this, AvisosActivity.class);
        startActivity(intent);

    }



}
