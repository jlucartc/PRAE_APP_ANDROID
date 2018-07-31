package com.example.luca.prae_app.view.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.luca.prae_app.menu_pages.categorias.SecaoActivity;
import com.example.luca.prae_app.models.Secao;

public class SecaoClickListener implements View.OnClickListener {

    private Context context;
    private Secao secao;

    public SecaoClickListener(Context context,Secao secao){

        this.context = context;
        this.secao = secao;

    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this.context,SecaoActivity.class);

        i.putExtra("secaoId",this.secao.getId());
        i.putExtra("secaoNome",this.secao.getNome());

        view.getContext().startActivity(i);

    }
}
