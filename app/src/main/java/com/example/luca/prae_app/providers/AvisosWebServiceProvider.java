package com.example.luca.prae_app.providers;

import android.os.AsyncTask;

import com.example.luca.prae_app.models.Aviso;
import com.example.luca.prae_app.models.Categoria;

public class AvisosWebServiceProvider extends AsyncTask<Void,Void,Aviso[]> {

    @Override
    protected Aviso[] doInBackground(Void... voids) {
        return new Aviso[0];
    }

}
