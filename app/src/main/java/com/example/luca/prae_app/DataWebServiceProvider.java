package com.example.luca.prae_app;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class DataWebServiceProvider {

    private static final String  url = "http://192.168.0.104:8000/app/ws/noticias";

    private Noticia[] noticias;
    private StringRequest stringRequestNoticias;
    private RequestQueue requestQueue;
    private Context context;
    private Gson gson;

    public DataWebServiceProvider(Context context){

        this.context = context;
        this.noticias = null;
        this.requestQueue = Volley.newRequestQueue(this.context);
        this.gson = new Gson();

        this.stringRequestNoticias = new StringRequest(Request.Method.GET,this.url, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {

                noticias = gson.fromJson(response,Noticia[].class);

            }
        },new Response.ErrorListener(){


            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i("ErroDWSP","Erro na requisição");

            }
        });

    }

    public Noticia[] getNoticias(){

        this.requestQueue.add(this.stringRequestNoticias);

        return this.noticias;

    }

}
