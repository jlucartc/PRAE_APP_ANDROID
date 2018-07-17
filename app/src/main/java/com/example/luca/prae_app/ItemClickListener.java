package com.example.luca.prae_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

import com.example.luca.prae_app.NoticiaWebViewActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ItemClickListener implements View.OnClickListener {

    private Context context;
    private TextView url;
    private int id;

    public ItemClickListener(Context context){

        this.context= context;

    }


    @Override
    public void onClick(View view) {

        this.url = (TextView)view.findViewById(R.id.url);

        Intent intent = new Intent(this.context,NoticiaWebViewActivity.class);

        intent.putExtra("url",this.url.getText());

        SharedPreferences sh = this.context.getSharedPreferences("com.example.luca.prae_app",Context.MODE_PRIVATE);

        Scanner s = new Scanner(sh.getString("noticiasNaoLidasArray",""));

        ArrayList<Integer> noticiasNaoLidasArrayList = new ArrayList<Integer>();

        while(s.hasNextInt()) {

            noticiasNaoLidasArrayList.add(s.nextInt());

        }

        int id = Integer.parseInt((String)((TextView)view.findViewById(R.id.id)).getText());

        if(noticiasNaoLidasArrayList.indexOf(id) >= 0){

            noticiasNaoLidasArrayList.remove(noticiasNaoLidasArrayList.indexOf(id));

            StringBuilder sb = new StringBuilder();

            Iterator<Integer> i = noticiasNaoLidasArrayList.iterator();

            while(i.hasNext()){

                sb.append(String.valueOf(i.next())).append(" ");

            }

            SharedPreferences.Editor editor = sh.edit();

            editor.putString("noticiasNaoLidasArray",sb.toString());

            editor.commit();

        }

        this.context.startActivity(intent);

    }
}
