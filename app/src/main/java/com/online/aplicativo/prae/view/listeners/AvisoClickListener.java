package com.online.aplicativo.prae.view.listeners;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

import com.online.aplicativo.prae.R;
import com.online.aplicativo.prae.menu_pages.avisos.AvisoDetalhesActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AvisoClickListener implements View.OnClickListener {

    private String avisoMensagem;
    private String titulo;
    private String url;

    @Override
    public void onClick(View view) {

        this.avisoMensagem = ((TextView)view.findViewById(R.id.mensagemAviso)).getText().toString().trim();
        this.titulo = ((TextView)view.findViewById(R.id.titulo)).getText().toString().trim();
        this.url = ((TextView)view.findViewById(R.id.avisoUrl)).getText().toString().trim();

        Intent intent = new Intent(view.getContext(),AvisoDetalhesActivity.class);

        SharedPreferences sh = view.getContext().getSharedPreferences("com.example.luca.prae_app", Context.MODE_PRIVATE);

        Scanner s = new Scanner(sh.getString("avisosNaoVistosArray",""));

        ArrayList<Integer> avisosNaoVistosArrayList = new ArrayList<Integer>();

        while(s.hasNextInt()) {

            avisosNaoVistosArrayList.add(s.nextInt());

        }

        int id = Integer.parseInt(((TextView)view.findViewById(R.id.avisoId)).getText().toString());

        if(avisosNaoVistosArrayList.indexOf(id) >= 0){

            avisosNaoVistosArrayList.remove(avisosNaoVistosArrayList.indexOf(id));

            StringBuilder sb = new StringBuilder();

            Iterator<Integer> i = avisosNaoVistosArrayList.iterator();

            while(i.hasNext()){

                sb.append(String.valueOf(i.next())).append(" ");

            }

            SharedPreferences.Editor editor = sh.edit();

            editor.putString("avisosNaoVistosArray",sb.toString());

            editor.commit();

        }

        intent.putExtra("avisoMensagem",this.avisoMensagem);
        intent.putExtra("titulo",this.titulo);
        intent.putExtra("url",this.url);

        view.getContext().startActivity(intent);

    }


}
