package com.example.luca.prae_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import androidx.work.Worker;

public class AtualizarNoticias extends Worker {

    private Context context;
    private Noticia[] noticias;
    private DataWebServiceProvider dataWebServiceProvider;
    private SharedPreferences sharedṔreferences;
    private int ultimoId;
    private ArrayList<Integer> noticiasNaoLidasArray;

    @NonNull
    @Override
    public Worker.Result doWork() {

    this.context = this.getApplicationContext();
    this.dataWebServiceProvider = new DataWebServiceProvider();
    Log.i("isNull",String.valueOf((boolean)(this.context == null)));
    this.sharedṔreferences = this.context.getSharedPreferences("com.example.luca.prae_app",Context.MODE_PRIVATE);
    this.noticiasNaoLidasArray = new ArrayList<Integer>();

    this.ultimoId = this.sharedṔreferences.getInt("ultimoId",0);
    String s = this.sharedṔreferences.getString("noticiasNaoLidasArray","0");
    Scanner scanner = new Scanner(s);
    while(scanner.hasNextInt()){
        this.noticiasNaoLidasArray.add(scanner.nextInt());
    }

    this.noticias = this.dataWebServiceProvider.getNoticias();

        ArrayList<Integer> oldNoticiasNaoLidas = (ArrayList<Integer>) this.noticiasNaoLidasArray.clone();

        if(this.noticias != null) {
            for (Noticia n : this.noticias) {

                if (n.getId() > this.ultimoId) {

                    this.ultimoId = n.getId();
                    this.noticiasNaoLidasArray.add(n.getId());
                    n.setNova(true);

                }
            }

            if (this.noticiasNaoLidasArray.containsAll(oldNoticiasNaoLidas)) {

                ArrayList<Integer> diff = (ArrayList<Integer>) this.noticiasNaoLidasArray.clone();
                diff.removeAll(oldNoticiasNaoLidas);

                for (int i = 0; i < this.noticias.length; i++) {

                    if (diff.contains(this.noticias[i].getId())) {

                        /// emitir notificação;
                        Log.i("NOTIFICAÇÃO", "NOTIFICAÇÃO DE NOVA NOTÍCIA!!!");

                    }

                }


            }
        }

        SharedPreferences.Editor editor = this.sharedṔreferences.edit();

        StringBuilder construtorString = new StringBuilder();

        int[] noticiasNaoLidasIntArray = new int[this.noticiasNaoLidasArray.size()];

        Integer[] integerArrayList = this.noticiasNaoLidasArray.toArray(new Integer[this.noticiasNaoLidasArray.size()]);

        for (int i = 0; i < noticiasNaoLidasIntArray.length; i++) {

            noticiasNaoLidasIntArray[i] = integerArrayList[i].intValue();

        }

        StringBuilder builder = new StringBuilder();

        for (int i : noticiasNaoLidasIntArray) {

            builder.append(i).append(" ");

        }

        editor.putInt("ultimoId", this.ultimoId);
        editor.putString("noticiasNaoLidasArray", builder.toString());

        return Result.SUCCESS;

    }

}
