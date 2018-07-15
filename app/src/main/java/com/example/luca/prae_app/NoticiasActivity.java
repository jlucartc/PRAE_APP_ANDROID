package com.example.luca.prae_app;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class NoticiasActivity extends AppCompatActivity {

    private Noticia[] noticias;
    private DataWebServiceProvider dataWebServiceProvider;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Noticias");

        this.dataWebServiceProvider = new DataWebServiceProvider(this.getApplicationContext());
        try {

            this.noticias = this.dataWebServiceProvider.execute().get();

            if(this.noticias.length == 0){

                setContentView(R.layout.sem_noticias_layout);

            }else{

                setContentView(R.layout.activity_noticias);

                this.recyclerView = (RecyclerView)findViewById(R.id.noticiasRecyclerView);
                this.layoutManager = new LinearLayoutManager(this);
                //Log.i("qNews",String.valueOf(this.noticias.length));
                this.adapter = new NoticiasAdapter(this.noticias);
                this.recyclerView.setLayoutManager(this.layoutManager);
                this.recyclerView.setAdapter(this.adapter);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }




    }



    public void verNoticia(){

        // abrir webview para acessar link da notícia.

    }

}
