package com.example.luca.prae_app.providers;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.example.luca.prae_app.models.Noticia;
import com.example.luca.prae_app.menu_pages.noticias.NoticiasActivity;
import com.example.luca.prae_app.R;
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
import java.util.Iterator;
import java.util.Scanner;

public class NoticiasWebServiceProvider extends AsyncTask<Void, Void, Noticia[]> {

    private Noticia[] noticiasArray;
    private String NOTICIAS_URI;
    private Context context;
    private Gson gson;

    public NoticiasWebServiceProvider(Context context){

        this.context = context;

        this.NOTICIAS_URI = this.context.getString(R.string.localhost)+"/app/ws/noticias";

        this.gson = new Gson();

    }

    public Noticia[] getNoticias(){

        try {

            URL url = new URL(this.NOTICIAS_URI);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            this.noticiasArray = gson.fromJson(response,Noticia[].class);

            if(this.noticiasArray != null){

                ArrayList<Noticia> arrayList = new ArrayList<Noticia>(Arrays.asList(this.noticiasArray));
                Collections.sort(arrayList, new Comparator<Noticia>() {
                    @Override
                    public int compare(Noticia noticia, Noticia t1) {
                        return (noticia.getId() > t1.getId()) ? -1 : 1;
                    }
                });

                this.noticiasArray = arrayList.toArray(new Noticia[arrayList.size()]);

                this.checkNoticias(this.noticiasArray);

            }else{

                this.noticiasArray = new Noticia[0];

                this.checkNoticias(this.noticiasArray);

            }

            httpCon.disconnect();

            inputStreamReader.close();

            inputStream.close();

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();

            this.noticiasArray = new Noticia[0];

            this.checkNoticias(this.noticiasArray);

        }


        return this.noticiasArray;

    }

    @Override
    protected Noticia[] doInBackground(Void... voids){

        return this.getNoticias();
    }

    public void checkNoticias(Noticia[] noticias){

        SharedPreferences sp = this.context.getSharedPreferences("com.example.luca.prae_app",Context.MODE_PRIVATE);

        String noticiasNaoLidasArray = sp.getString("noticiasNaoLidasArray","");

        int ultimoId = sp.getInt("ultimoId",0);

        int qNotificacoes = sp.getInt("qNotificacoes",0);

        Log.i("NoticiasWSProvider","ultimoId: "+String.valueOf(ultimoId));

        Log.i("NoticiasWSProvider","noticiasNaoLidasArray: "+String.valueOf(noticiasNaoLidasArray));

        Log.i("NoticiasWSProvider","noticias.length: "+String.valueOf(noticias.length));

        ArrayList<Integer> noticiasNaoLidasArrayList = new ArrayList<Integer>();

        Scanner s = new Scanner(noticiasNaoLidasArray);

        // ArrayList<Integer> noticiasNaoLidasArrayList = new ArrayList<Integer>();

        // Montando o ArrayList com as noticias não lidas

        while(s.hasNextInt()){

            int i = s.nextInt();

            Log.i("NoticiasWSProvider","Noticia não lida: "+String.valueOf(i));

            noticiasNaoLidasArrayList.add(i);

        }

        /*
        * Checando cada item no array de notícias não lidas.
        * */

        int tempId = ultimoId;

        //ArrayList<Integer> notificarApos = new ArrayList<Integer>();

        for(Noticia n : noticias){

            Log.i("NoticiasWSProvider","n.getId(): "+String.valueOf(n.getId()));

            if(noticiasNaoLidasArrayList.indexOf(n.getId()) >= 0){

                n.setNova(true);

            }else{

                if(n.getId() > ultimoId){

                    noticiasNaoLidasArrayList.add(n.getId());
                    n.setNova(true);

                    if(n.getId() > tempId){

                        tempId = n.getId();

                    }

                    //notificarApos.add(n.getId());

                }else{

                    n.setNova(false);

                }

            }

        }

        /*for(int i = notificarApos.size()-1 ; i >= 0; i-- ){

            Intent intent = new Intent(this.context,NoticiasActivity.class);
            NotificationCompat.Builder notificacao = new NotificationCompat.Builder(this.context).setSmallIcon(R.drawable.ic_prae_app_notificacoes_icon).setContentTitle("Nova notícia!").setContentText(noticias[noticias.length - notificarApos.get(i)].getTitulo());
            TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this.context);
            taskStackBuilder.addParentStack(NoticiasActivity.class);
            taskStackBuilder.addNextIntent(intent);
            PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
            notificacao.setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager)this.context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify("prae.noticias",1,notificacao.build());

            Log.i("NoticiasWSProvider","noticia.getId(): "+noticias[notificarApos.get(i)-1].getTitulo());

        }*/


        ultimoId = tempId;

        StringBuilder stringBuilder = new StringBuilder();

        Iterator iterator = noticiasNaoLidasArrayList.iterator();

        while(iterator.hasNext()){

            stringBuilder.append(iterator.next()).append(" ");

        }

        SharedPreferences.Editor editor = sp.edit();


        editor.putInt("qNotificacoes",qNotificacoes);

        editor.putString("noticiasNaoLidasArray",stringBuilder.toString());

        editor.putInt("ultimoId",ultimoId);

        editor.commit();

        this.noticiasArray = noticias;

    }


}