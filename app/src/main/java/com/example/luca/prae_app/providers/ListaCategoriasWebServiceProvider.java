package com.example.luca.prae_app.providers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Categoria;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ListaCategoriasWebServiceProvider extends AsyncTask<Void,Void,Categoria[]> {

    private Categoria[] categoriasArray;
    private String CATEGORIAS_URI;
    private Context context;
    private Gson gson;

    public ListaCategoriasWebServiceProvider(Context context){

        this.context = context;

        this.CATEGORIAS_URI = this.context.getString(R.string.localhost)+"/app/ws/listaCategorias";

        this.gson = new Gson();

    }

    public Categoria[] getCategoria(){

        try {

            URL url = new URL(this.CATEGORIAS_URI);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            Log.i("LISTACATEGORIAS",response);

            this.categoriasArray = gson.fromJson(response,Categoria[].class);

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
}
