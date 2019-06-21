package com.ufc.aplicativo.prae.workers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.ufc.aplicativo.prae.models.Noticia;
import com.ufc.aplicativo.prae.providers.AvisosWebServiceProvider;
import com.ufc.aplicativo.prae.providers.NoticiasWebServiceProvider;

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

    /*
    *   Função responsável por executar os códigos que se comunicam com
    *   o webservice e retornam os dados de notícias e de avisos. Esse código executa
    *   a cada 15 minutos.
    *
    *
    * */

    public Worker.Result doWork() {

        this.context = this.getApplicationContext();

        this.avisosWebServiceProvider = new AvisosWebServiceProvider(this.context);

        // Checa se o código já está sendo rodado
        if(this.avisosWebServiceProvider.getStatus() != AsyncTask.Status.RUNNING){


            this.avisosWebServiceProvider.execute();

        }

        return Result.SUCCESS;

    }

}
