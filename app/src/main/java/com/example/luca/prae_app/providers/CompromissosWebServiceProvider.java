package com.example.luca.prae_app.providers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Compromisso;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class CompromissosWebServiceProvider extends AsyncTask<Void,Void,Compromisso[]> {

    private Compromisso[] compromissosArray;
    private String COMPROMISSOS_URI;
    private Gson gson;
    private Context context;

    public CompromissosWebServiceProvider(Context context){

        this.context = context;

        this.gson = new Gson();

        this.COMPROMISSOS_URI = this.context.getString(R.string.localhost)+"/app/ws/compromissos";

    }

    public Compromisso[] getCompromissos(){

        try {

            URL url = new URL(this.COMPROMISSOS_URI);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            this.compromissosArray = gson.fromJson(response,Compromisso[].class);

            if(this.compromissosArray == null){

                this.compromissosArray = new Compromisso[0];

            }

            httpCon.disconnect();

            inputStreamReader.close();

            inputStream.close();

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();

            this.compromissosArray = new Compromisso[0];


        }


        return this.compromissosArray;

    }

    @Override
    protected Compromisso[] doInBackground(Void... voids) {
        return this.getCompromissos();
    }
}
