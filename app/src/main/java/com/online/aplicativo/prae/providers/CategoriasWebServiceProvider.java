package com.online.aplicativo.prae.providers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.online.aplicativo.prae.R;
import com.online.aplicativo.prae.models.Categoria;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class CategoriasWebServiceProvider extends AsyncTask<Void,Void,Categoria[]> {

    private Categoria[] categoriasArray;
    private String categoriasUri;
    private Context context;
    private Gson gson;

    public CategoriasWebServiceProvider(Context context,int tipo){

        this.setContext(context);

        this.setCategoriasUri(this.context.getString(R.string.localhost)+"/app/ws/categorias/"+String.valueOf(tipo));

        this.setGson(new Gson());

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

            this.categoriasArray = gson.fromJson(response,Categoria[].class);


            JSONArray array = new JSONArray(response);
            Categoria[] categorias = new Categoria[array.length()];

            for(int i = 0; i < array.length(); i++){

                categorias[i] = this.getGson().fromJson(array.getJSONObject(i).toString(),Categoria.class);

            }

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


        } catch (JSONException e) {
            e.printStackTrace();
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
