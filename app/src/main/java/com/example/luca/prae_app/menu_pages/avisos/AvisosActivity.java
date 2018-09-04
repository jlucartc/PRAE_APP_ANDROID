package com.example.luca.prae_app.menu_pages.avisos;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.providers.AvisosWebServiceProvider;

public class AvisosActivity extends AppCompatActivity {

    private AvisosWebServiceProvider avisosWebServiceProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos);

        this.avisosWebServiceProvider = new AvisosWebServiceProvider(this.getApplicationContext());

    }

    public void checarAvisos(View v){

        if(this.avisosWebServiceProvider.getStatus() != AsyncTask.Status.RUNNING){
            this.avisosWebServiceProvider.execute();
        }

    }

}


