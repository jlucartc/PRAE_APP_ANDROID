package com.example.luca.prae_app;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

public class MainActivity extends AppCompatActivity {

    private Button noticias;
    private WorkRequest atualizarNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity","MainActivity foi executada");

        if(this.atualizarNoticias == null){
            Log.i("WorkerRequestState","NULL");
            this.atualizarNoticias = new PeriodicWorkRequest.Builder(AtualizarNoticias.class,15,TimeUnit.MINUTES).build();
            WorkManager.getInstance().enqueue(atualizarNoticias);
        }



    }

    public void noticias(View view){

        Intent intent = new Intent(this,NoticiasActivity.class);
        startActivity(intent);
    }

}
