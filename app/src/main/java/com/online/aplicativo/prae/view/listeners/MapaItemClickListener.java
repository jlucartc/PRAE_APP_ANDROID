package com.online.aplicativo.prae.view.listeners;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.online.aplicativo.prae.menu_pages.mapa_da_prae.MostrarMapaActivity;
import com.online.aplicativo.prae.R;
import com.online.aplicativo.prae.models.Mapa;

public class MapaItemClickListener implements View.OnClickListener {

    private Context context;
    private TextView rota;
    private int mapaId;
    private String nome;


    public MapaItemClickListener(Context context, int mapaId){

        this.mapaId = mapaId;
        this.context = context;

    }

    @Override
    public void onClick(View view) {

        this.rota = view.findViewById(R.id.rota);

        this.nome = ((TextView)view.findViewById(R.id.nome)).getText().toString();

        String url = this.context.getString(R.string.localhost)+this.rota.getText().toString();

        Intent intent = new Intent(this.context,MostrarMapaActivity.class);

        intent.putExtra("nome",/*this.nome*/"Nome");

        intent.putExtra("rota",url);

        intent.putExtra("mapaId",this.mapaId);

        this.context.startActivity(intent);

    }
}
