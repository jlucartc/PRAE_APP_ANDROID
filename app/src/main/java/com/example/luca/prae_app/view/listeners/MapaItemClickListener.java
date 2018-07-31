package com.example.luca.prae_app.view.listeners;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.luca.prae_app.menu_pages.mapa_da_prae.MostrarMapaActivity;
import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Mapa;

public class MapaItemClickListener implements View.OnClickListener {

    private Context context;
    private TextView rota;
    private int mapaId;


    public MapaItemClickListener(Context context, int mapaId){

        this.mapaId = mapaId;
        this.context = context;

    }

    @Override
    public void onClick(View view) {

        this.rota = view.findViewById(R.id.rota);

        String url = this.context.getString(R.string.localhost)+this.rota.getText().toString();

        Intent intent = new Intent(this.context,MostrarMapaActivity.class);

        Log.i("mapaonclicklistener",url);

        intent.putExtra("rota",url);

        intent.putExtra("mapaId",this.mapaId);

        this.context.startActivity(intent);

    }
}
