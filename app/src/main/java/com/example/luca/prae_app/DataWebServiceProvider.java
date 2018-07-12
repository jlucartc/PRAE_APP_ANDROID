package com.example.luca.prae_app;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DataWebServiceProvider{

    private static final String endereco = "http://192.168.2.108:8000/app/ws/noticias";

    private Noticia[] noticias;
    private StringRequest stringRequestNoticias;
    private RequestQueue requestQueue;
    private Context context;
    private Gson gson;

    public DataWebServiceProvider(){

        try {

            URL url = new URL(this.endereco);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            Log.i("DATAWEBSERVICEPROVIDER",response);

            this.noticias = null;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Noticia[] getNoticias(){

        return this.noticias;

    }

}
