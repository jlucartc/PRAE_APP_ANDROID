package com.example.luca.prae_app;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.CardView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class NoticiasActivity extends Activity {

    private Noticia[] noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

    }

    public void buscarNoticias(){



    }

    public boolean isServicoAtivo(Class<?> classeServico){

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for(ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)){

            if(classeServico.getName().equals(service.service.getClass())){

                return true;

            }

        }

        return false;

    }

}
