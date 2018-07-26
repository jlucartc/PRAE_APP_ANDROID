package com.example.luca.prae_app.providers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public interface WebServiceProvider{

    String objetosUri;
    Object[] objetos;
    Class classe;
    Gson gson;

    private Object[] getObjetos(String uri, Context context, Gson gson){

        try {

            URL url = new URL(uri);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            Log.i("DATAWEBSERVICEPROVIDER",response);

            Type typeOfT = new TypeToken<Object[]>(){}.getType();

            this.setObjet gson.fromJson(response,typeOfT));

            Log.i("isNoticiasArrayNull",String.valueOf(this.getObjetos() == null));

            if(this.getObjetos() == null){

                this.setObjetos(new Object[0]);


            }

            httpCon.disconnect();

            inputStreamReader.close();

            inputStream.close();

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();

            this.setObjetos(new Object[0]);

        }


        return this.getObjetos();

    }

}
