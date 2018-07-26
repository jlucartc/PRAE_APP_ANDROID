package com.example.luca.prae_app.providers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Paragrafo;
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

public class ParagrafosWebServiceProvider extends AsyncTask<Void,Void,Paragrafo[]> {

    private Context context;
    private String paragrafos_uri;
    private Paragrafo[] paragrafos;
    private Gson gson;

    public ParagrafosWebServiceProvider(Context context, int id){

        this.context = context;
        this.paragrafos_uri = this.context.getString(R.string.localhost)+"/app/ws/paragrafos/"+String.valueOf(id);
        this.gson = new Gson();

    }

    @Override
    protected Paragrafo[] doInBackground(Void... voids) {
        return this.getParagrafos();
    }

    public Paragrafo[] getParagrafos(){

        try {

            URL url = new URL(this.paragrafos_uri);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            Log.i("DATAWEBSERVICEPROVIDER",response);

            this.paragrafos = gson.fromJson(response,Paragrafo[].class);

            Log.i("isNoticiasArrayNull",String.valueOf(this.paragrafos == null));

            if(this.paragrafos_uri == null){

                this.paragrafos = new Paragrafo[0];

            }

            httpCon.disconnect();

            inputStreamReader.close();

            inputStream.close();

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();

            this.paragrafos = new Paragrafo[0];

        }


        return this.paragrafos;


    }

}
