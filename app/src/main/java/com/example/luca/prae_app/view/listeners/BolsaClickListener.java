package com.example.luca.prae_app.view.listeners;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.luca.prae_app.menu_pages.bolsas.BolsaDetalhesActivity;
import com.example.luca.prae_app.menu_pages.categorias.CategoriaDetalhesActivity;
import com.example.luca.prae_app.models.Categoria;

public class BolsaClickListener implements View.OnClickListener {

    private Context context;
    private Categoria bolsa;
    private int bolsaId;

    public BolsaClickListener(Context context,Categoria bolsa){

        this.context = context;
        this.bolsa = bolsa;
        this.bolsaId = bolsa.getId();
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this.context,BolsaDetalhesActivity.class);

        i.putExtra("categoriaId",this.bolsaId);
        i.putExtra("nome",this.bolsa.getNome());
        i.putExtra("descricao",this.bolsa.getDescricao());

        this.context.startActivity(i);

    }


}
