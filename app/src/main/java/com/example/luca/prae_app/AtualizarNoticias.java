package com.example.luca.prae_app;

import android.content.Context;
import android.support.annotation.NonNull;

import androidx.work.Worker;

public class AtualizarNoticias extends Worker {

    private Context context;
    private Noticia[] noticias;
    private DataWebServiceProvider dataWebServiceProvider;

    public AtualizarNoticias(Context context){

        this.context = context;
        this.dataWebServiceProvider = new DataWebServiceProvider(this.context);
    }

    @NonNull
    @Override
    public WorkerResult doWork() {

        this.noticias = this.dataWebServiceProvider.getNoticias();

        ///Checar variaveis de estado e notificar caso necessario

        return WorkerResult.SUCCESS;

    }
}
