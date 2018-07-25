package com.example.luca.prae_app.view.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.luca.prae_app.menu_pages.bolsas.BolsaDetalhesActivity;
import com.example.luca.prae_app.models.Categoria;

public class BolsaClickListener implements View.OnClickListener {

    private Context context;
    private Categoria bolsa;

    public BolsaClickListener(Context context,Categoria bolsa){

        this.context = context;
        this.bolsa = bolsa;

    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this.context,BolsaDetalhesActivity.class);

        i.putExtra("secoes",this.bolsa.getSecoes().toString());
        i.putExtra("documentos",this.bolsa.getDocumentos().toString());

        this.context.startActivity(i);

    }


}
