package com.example.luca.prae_app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

class DataWebServiceProvider extends AsyncTask<Void, Void, Noticia[]> {

    private static final String endereco = "http://192.168.0.104:8000/app/ws/noticias";

    private Noticia[] noticiasArray;
    private Context context;
    private Gson gson;

    public DataWebServiceProvider(Context context){

        this.context = context;

    }

    public Noticia[] getNoticias(){

        try {

            this.gson = new Gson();

            URL url = new URL(this.endereco);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            Log.i("DATAWEBSERVICEPROVIDER",response);

            this.noticiasArray = gson.fromJson(response,Noticia[].class);

            Log.i("isNoticiasArrayNull",String.valueOf(this.noticiasArray == null));

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

        Scanner s = new Scanner(noticiasNaoLidasArray);

        ArrayList<Integer> noticiasNaoLidasArrayList = new ArrayList<Integer>();

        while(s.hasNextInt()){

            noticiasNaoLidasArrayList.add(s.nextInt());
            Log.i("naoLidas",String.valueOf(noticiasNaoLidasArrayList.get(noticiasNaoLidasArrayList.size()-1)));

        }


        for(Noticia n : noticias){

            if(noticiasNaoLidasArrayList.indexOf(n.getId()) >= 0){

                n.setNova(true);

            }else{

                if(n.getId() > ultimoId){

                    noticiasNaoLidasArrayList.add(n.getId());
                    n.setNova(true);
                    ultimoId = n.getId();

                    Intent intent = new Intent(this.context,NoticiasActivity.class);
                    NotificationCompat.Builder notificacao = new NotificationCompat.Builder(this.context).setSmallIcon(R.drawable.ic_prae_app_notificacoes_icon).setContentTitle("Nov notícia!").setContentText(n.getTitulo());
                    TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this.context);
                    taskStackBuilder.addParentStack(NoticiasActivity.class);
                    taskStackBuilder.addNextIntent(intent);
                    PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                    notificacao.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager)this.context.getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(1,notificacao.build());

                }else{

                    n.setNova(false);

                }

            }

            Log.i("noticiaIsNova",String.valueOf(n.isNova()));

        }

        StringBuilder stringBuilder = new StringBuilder();

        Iterator iterator = noticiasNaoLidasArrayList.iterator();

        while(iterator.hasNext()){

            stringBuilder.append(iterator.next()).append(" ");

        }

        SharedPreferences.Editor editor = sp.edit();

        editor.putString("noticiasNaoLidasArray",stringBuilder.toString());

        editor.putInt("ultimoId",ultimoId);

        editor.commit();


        this.noticiasArray = noticias;

    }


}