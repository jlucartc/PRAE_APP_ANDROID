package com.example.luca.prae_app.providers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Documento;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DocumentosWebServiceProvider extends AsyncTask<Void,Void,Documento[]> {

    private String documentosUri;
    private Context context;
    private Documento[] documentos;
    private Gson gson;

    @Override
    protected Documento[] doInBackground(Void... voids) {
        return this.getDocumentos();
    }

    public DocumentosWebServiceProvider(Context context,int id){

        this.context = context;
        this.documentosUri = this.context.getString(R.string.localhost)+"/app/ws/documentos/"+String.valueOf(id);
        this.gson = new Gson();

    }


    public Documento[] getDocumentos(){

        try {

            URL url = new URL(this.documentosUri);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            Log.i("LISTACOMPROMISSOS",response);

            this.documentos = gson.fromJson(response,Documento[].class);

            if(this.documentos == null){

                this.documentos = new Documento[0];

            }

            httpCon.disconnect();

            inputStreamReader.close();

            inputStream.close();

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();

            this.documentos = new Documento[0];


        }


        return this.documentos;


    }
}
