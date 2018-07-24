package com.example.luca.prae_app.providers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Categoria;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class CategoriasWebServiceProvider extends AsyncTask<Void,Void,Categoria[]> {

    private Categoria[] categoriasArray;
    private String categoriasUri;
    private Context context;
    private Gson gson;

    public CategoriasWebServiceProvider(Context context){

        this.context = context;

        this.categoriasUri = this.context.getString(R.string.localhost)+"/app/ws/listaCategorias";

        this.gson = new Gson();

    }

    public Categoria[] getCategoria(){

        try {

            URL url = new URL(this.categoriasUri);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            Log.i("LISTACATEGORIAS",response);

            this.categoriasArray = gson.fromJson(response,Categoria[].class);

            //JSONObject responseJson = new JSONObject(response);

            if(this.categoriasArray == null){

                this.categoriasArray = new Categoria[0];

            }

            httpCon.disconnect();

            inputStreamReader.close();

            inputStream.close();

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();

            this.categoriasArray = new Categoria[0];


        }


        return this.categoriasArray;

    }

    @Override
    protected  Categoria[] doInBackground(Void... voids) {

        return this.getCategoria();

    }

    public String getCategoriasUri() {
        return categoriasUri;
    }

    public void setCategoriasUri(String categoriasUri) {
        this.categoriasUri = categoriasUri;
    }

    public Categoria[] getCategoriasArray() {
        return categoriasArray;
    }

    public void setCategoriasArray(Categoria[] categoriasArray) {
        this.categoriasArray = categoriasArray;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
