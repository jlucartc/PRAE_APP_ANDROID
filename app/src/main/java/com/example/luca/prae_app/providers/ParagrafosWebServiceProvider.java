package com.example.luca.prae_app.providers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Item;
import com.example.luca.prae_app.models.Lista;
import com.example.luca.prae_app.models.Paragrafo;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private String paragrafosUri;
    private Paragrafo[] paragrafos;
    private Gson gson;
    private int secaoId;

    public ParagrafosWebServiceProvider(Context context, int secaoId){

        this.secaoId = secaoId;
        this.context = context;
        this.paragrafosUri = this.context.getString(R.string.localhost)+"/app/ws/paragrafos/"+String.valueOf(this.secaoId);
        this.gson = new Gson();
        this.paragrafos = new Paragrafo[0];


    }

    @Override
    protected Paragrafo[] doInBackground(Void... voids) {
        return this.getParagrafos();
    }

    public Paragrafo[] getParagrafos(){

        try {

            URL url = new URL(this.paragrafosUri);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            JSONArray responseJSON = new JSONArray(response);

            this.paragrafos = new Paragrafo[responseJSON.length()];

            if(responseJSON.length() > 0){

                for(int i = 0; i < responseJSON.length(); i++){

                    JSONObject paragrafo = responseJSON.getJSONObject(i);

                    this.paragrafos[i] = this.gson.fromJson(paragrafo.toString(),Paragrafo.class);

                    JSONArray listas = paragrafo.getJSONArray("listas");

                    this.paragrafos[i].setListas(this.gson.fromJson(listas.toString(),Lista[].class));

                    for(int j = 0; j < this.paragrafos[i].getListas().length; j++){

                        JSONArray itens = listas.getJSONObject(j).getJSONArray("itens");
                        this.paragrafos[i].getListas()[j].setItens(this.gson.fromJson(itens.toString(),Item[].class));

                    }

                }

            }

            httpCon.disconnect();

            inputStreamReader.close();

            inputStream.close();

            bufferedReader.close();

            return this.paragrafos;

        } catch (IOException e) {
            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return this.paragrafos;


    }

}
