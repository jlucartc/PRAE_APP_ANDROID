package com.example.luca.prae_app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProvedorService extends Service {

    private RequestQueue requestQ;
    private Noticia[] noticiasService;

    public ProvedorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.d("buscarNoticias","Buscando notícias...");
        this.requestQ = Volley.newRequestQueue(this);
        this.buscarNoticias();
        return Service.START_STICKY;
    }

    public void buscarNoticias(){

        String url = "http://192.168.0.104:8000/app/ws/noticias";

        StringRequest request  = new StringRequest(Request.Method.GET,url,new Response.Listener<String>() {

            public void onResponse(String response) {

                Gson gson = new Gson();
                Noticia[] noticias = gson.fromJson(response,Noticia[].class);

                for( Noticia noticia : noticias ){

                    Log.i("noticia.guid",noticia.getGuid());

                }

                noticiasService = noticias;

            }

        },new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {

                Log.e("Error",error.getMessage());

            }

        });

        this.requestQ.add(request);
        this.requestQ.start();

    }
}