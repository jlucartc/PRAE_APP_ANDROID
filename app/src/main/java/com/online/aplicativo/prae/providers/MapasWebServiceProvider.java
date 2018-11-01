package com.online.aplicativo.prae.providers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.online.aplicativo.prae.R;
import com.online.aplicativo.prae.models.Mapa;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MapasWebServiceProvider extends AsyncTask<Void,Void,Mapa[]> {

    private Mapa[] mapasArray;
    private Gson gson;
    private String MAPAS_URI;
    private Context context;


    public MapasWebServiceProvider(Context context){

        this.context = context;
        this.gson = new Gson();
        this.MAPAS_URI = this.context.getString(R.string.localhost)+"/app/ws/mapas";

    }

    @Override
    protected Mapa[] doInBackground(Void... voids) {

        return this.getMapas();

    }

    public Mapa[] getMapas(){

        try {

            URL url = new URL(this.MAPAS_URI);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            this.mapasArray = gson.fromJson(response,Mapa[].class);

            if(this.mapasArray == null){

                this.mapasArray = new Mapa[0];

            }

            httpCon.disconnect();

            inputStreamReader.close();

            inputStream.close();

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();

            this.mapasArray = new Mapa[0];


        }


        return this.mapasArray;

    }
}
