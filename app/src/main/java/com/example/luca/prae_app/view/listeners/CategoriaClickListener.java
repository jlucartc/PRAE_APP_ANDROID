package com.example.luca.prae_app.view.listeners;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.luca.prae_app.menu_pages.categorias.CategoriaDetalhesActivity;
import com.example.luca.prae_app.models.Categoria;

public class CategoriaClickListener implements View.OnClickListener {

    private Context context;
    private Categoria categoria;

    public CategoriaClickListener(Context context, Categoria categoria){

        this.setCategoria(categoria);
        this.setContext(context);

    }

    @Override
    public void onClick(View view){

        Intent i = new Intent(this.context,CategoriaDetalhesActivity.class);

        i.putExtra("categoriaId",this.getCategoria().getId());
        i.putExtra("nome",this.getCategoria().getNome());
        i.putExtra("descricao",this.getCategoria().getDescricao());

        this.context.startActivity(i);

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria bolsa) {
        this.categoria = bolsa;
    }
}
