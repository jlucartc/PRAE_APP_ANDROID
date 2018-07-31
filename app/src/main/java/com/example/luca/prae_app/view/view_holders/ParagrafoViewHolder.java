package com.example.luca.prae_app.view.view_holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.luca.prae_app.R;

public class ParagrafoViewHolder extends RecyclerView.ViewHolder {

    private TextView titulo;
    private TextView texto;
    private LinearLayout listaListas;

    public ParagrafoViewHolder(@NonNull View itemView) {
        super(itemView);

        this.setTitulo((TextView)itemView.findViewById(R.id.titulo));
        this.setTitulo((TextView)itemView.findViewById(R.id.texto));
        this.setListaListas((LinearLayout) itemView.findViewById(R.id.listaListas));

    }

    public TextView getTitulo() {
        return titulo;
    }

    public void setTitulo(TextView titulo) {
        this.titulo = titulo;
    }

    public TextView getTexto() {
        return texto;
    }

    public void setTexto(TextView texto) {
        this.texto = texto;
    }

    public LinearLayout getListaListas() {
        return listaListas;
    }

    public void setListaListas(LinearLayout listaListas) {
        this.listaListas = listaListas;
    }
}
