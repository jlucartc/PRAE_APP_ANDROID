package com.example.luca.prae_app.view.listeners;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.luca.prae_app.menu_pages.mapa_da_prae.MostrarMapaActivity;
import com.example.luca.prae_app.R;

public class MapaItemClickListener implements View.OnClickListener {

    private Context context;
    private TextView rota;


    public MapaItemClickListener(Context context){

        this.context = context;

    }

    @Override
    public void onClick(View view) {

        Log.i("mapaonclicklistener","MOSTRAR MAPA");

        this.rota = view.findViewById(R.id.rota);

        String url = this.rota.getText().toString();

        Intent intent = new Intent(this.context,MostrarMapaActivity.class);

        intent.putExtra("rota",url);

        this.context.startActivity(intent);

    }
}
