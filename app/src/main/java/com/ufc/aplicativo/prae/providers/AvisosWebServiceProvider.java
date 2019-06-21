package com.ufc.aplicativo.prae.providers;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.menu_pages.avisos.AvisosActivity;
import com.ufc.aplicativo.prae.models.Aviso;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AvisosWebServiceProvider extends AsyncTask<Void,Void,Aviso[]> {

    private Context context;
    private String AVISOS_URI;
    private Gson gson;
    private Aviso[] avisosArray;

    public AvisosWebServiceProvider(Context context){

        this.context = context;

        this.AVISOS_URI = this.context.getString(R.string.localhost)+"/app/ws/avisos";

        this.gson = new Gson();

    }

    @Override
    protected Aviso[] doInBackground(Void... voids) {
        return this.getAvisos();
    }

    public Aviso[] getAvisos(){

        try {

            URL url = new URL(this.AVISOS_URI);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            this.avisosArray = gson.fromJson(response,Aviso[].class);

            if(this.avisosArray != null){

                ArrayList<Aviso> arrayList = new ArrayList<>(Arrays.asList(this.avisosArray));
                Collections.sort(arrayList, new Comparator<Aviso>() {
                    @Override
                    public int compare(Aviso aviso, Aviso t1) {
                        return (aviso.getId() > t1.getId()) ? -1 : 1;
                    }
                });

                this.avisosArray = arrayList.toArray(new Aviso[arrayList.size()]);

                this.checkAvisos(this.avisosArray);

            }else{

                this.avisosArray = new Aviso[0];

                this.checkAvisos(this.avisosArray);

            }

            httpCon.disconnect();

            inputStreamReader.close();

            inputStream.close();

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();

            this.avisosArray = new Aviso[0];

            this.checkAvisos(this.avisosArray);

        }

        Log.i("AvisosWSProvider","Terminando de checar avisos...");

        return this.avisosArray;

    }

    private void checkAvisos(Aviso[] avisos){

        SharedPreferences sp = this.context.getSharedPreferences("com.example.luca.prae_app",Context.MODE_PRIVATE);

        String avisosNaoVistosArray = sp.getString("avisosNaoVistosArray","");

        int ultimoIdAvisos = sp.getInt("ultimoIdAvisos",0);

        int qAvisos = sp.getInt("qAvisos",0);

        ArrayList<Integer> avisosNaoVistosArrayList = new ArrayList<>();

        Scanner s = new Scanner(avisosNaoVistosArray);

        // ArrayList<Integer> noticiasNaoLidasArrayList = new ArrayList<Integer>();

        // Montando o ArrayList com as noticias não lidas

        while(s.hasNextInt()){

            int i = s.nextInt();

            //Log.i("NoticiasWSProvider","Noticia não lida: "+String.valueOf(i));

            avisosNaoVistosArrayList.add(i);

        }

        /*
         * Checando cada item no array de notícias não lidas.
         * */

        int tempId = ultimoIdAvisos;

        ArrayList<Integer> notificarApos = new ArrayList<>();

        ArrayList<Integer> avisosArray = new ArrayList<>();


        for(Aviso n : avisos){

            avisosArray.add(n.getId());

            Log.i("AvisosWSProvider","n.getId(): "+String.valueOf(n.getId()));

            if(avisosNaoVistosArrayList.indexOf(n.getId()) >= 0){

                n.setNovo(true);

            }else{

                if(n.getId() > ultimoIdAvisos){

                    avisosNaoVistosArrayList.add(n.getId());
                    n.setNovo(true);

                    if(n.getId() > tempId){

                        tempId = n.getId();

                    }

                    notificarApos.add(n.getId());

                }else{

                    n.setNovo(false);

                }

            }

        }

        for(int i = (notificarApos.size()-1) /*notificarApos.size()-1*/ ; i >= 0 /*i >= 0*/; i-- /* i-- */){

            Intent intent = new Intent(this.context,AvisosActivity.class);
            int importancia = 0;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                importancia = NotificationManager.IMPORTANCE_HIGH;
            }
            NotificationChannel notificationChannel = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = new NotificationChannel(this.context.getString(R.string.avisosNotificacao),"Avisos",importancia);
            }
            NotificationCompat.Builder notificacao = new NotificationCompat.Builder(this.context,this.context.getString(R.string.avisosNotificacao))
                    .setSmallIcon(R.drawable.ic_prae_app_notificacoes_icon)
                    .setContentTitle(avisos[avisosArray.indexOf(notificarApos.get(i))].getTitulo())
                    .setContentText(avisos[avisosArray.indexOf(notificarApos.get(i))].getMensagem())
                    .setChannelId(this.context.getString(R.string.avisosNotificacao));
            TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this.context);
            taskStackBuilder.addParentStack(AvisosActivity.class);
            taskStackBuilder.addNextIntent(intent);
            PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
            notificacao.setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager)this.context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }

            if(notificationManager != null) {
                notificationManager.notify("prae.avisos", 1, notificacao.build());
            }

            Log.i("AvisosWSProvider","aviso.getId(): "+avisos[i].getTitulo());

        }

        ultimoIdAvisos = tempId;

        StringBuilder stringBuilder = new StringBuilder();

        for (Object anAvisosNaoVistosArrayList : avisosNaoVistosArrayList) {

            stringBuilder.append(anAvisosNaoVistosArrayList).append(" ");

        }

        SharedPreferences.Editor editor = sp.edit();

        editor.putInt("qAvisos",qAvisos);

        editor.putString("avisosNaoVistosArray",stringBuilder.toString());

        editor.putInt("ultimoIdAvisos",ultimoIdAvisos);

        editor.apply();

        this.avisosArray = avisos;

    }

}
