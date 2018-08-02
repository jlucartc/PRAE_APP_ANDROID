package com.example.luca.prae_app.providers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Compromisso;
import com.example.luca.prae_app.models.Secao;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SecoesWebServiceProvider extends AsyncTask<Void,Void,Secao[]> {

    private Secao[] secoesArray;
    private String secoesUri;
    private Gson gson;
    private Context context;
    private int categoriaId;

    public SecoesWebServiceProvider(Context context,int categoriaId){

        this.categoriaId = categoriaId;
        this.context = context;
        this.secoesArray = null;
        this.secoesUri = this.context.getString(R.string.localhost)+"/app/ws/secoes/"+String.valueOf(this.categoriaId);
        this.gson = new Gson();

    }


    @Override
    protected Secao[] doInBackground(Void... voids) {
        return this.getSecoes();
    }

    public Secao[] getSecoes(){

        try {

            URL url = new URL(this.secoesUri);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            this.secoesArray = gson.fromJson(response,Secao[].class);

            if(this.secoesArray == null){

                this.secoesArray = new Secao[0];

            }

            httpCon.disconnect();

            inputStreamReader.close();

            inputStream.close();

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();

            this.secoesArray = new Secao[0];


        }


        return this.secoesArray;

    }


}
