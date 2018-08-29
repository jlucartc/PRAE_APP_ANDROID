package com.example.luca.prae_app.workers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.example.luca.prae_app.models.Noticia;
import com.example.luca.prae_app.providers.AvisosWebServiceProvider;
import com.example.luca.prae_app.providers.NoticiasWebServiceProvider;

import java.util.ArrayList;

import androidx.work.Worker;

public class AtualizarDados extends Worker {

    private Context context;
    private Noticia[] noticias;
    private NoticiasWebServiceProvider noticiasWebServiceProvider;
    private AvisosWebServiceProvider avisosWebServiceProvider;
    private SharedPreferences sharedṔreferences;
    private int ultimoId;
    private ArrayList<Integer> noticiasNaoLidasArray;

    @SuppressLint("WrongThread")
    @NonNull
    @Override
    public Worker.Result doWork() {

        this.context = this.getApplicationContext();

        this.noticiasWebServiceProvider = new NoticiasWebServiceProvider(this.context);

        this.noticiasWebServiceProvider.execute();

        this.avisosWebServiceProvider = new AvisosWebServiceProvider(this.context);

        this.avisosWebServiceProvider.execute();

        return Result.SUCCESS;

    }

}
