package com.online.aplicativo.prae.view.view_holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.online.aplicativo.prae.R;

public class ListaViewHolder extends RecyclerView.ViewHolder {

    public TextView tituloLista;
    public LinearLayout listaItens;

    public ListaViewHolder(@NonNull View itemView) {
        super(itemView);

        this.setListaItens((LinearLayout) itemView.findViewById(R.id.listaItens));
        this.setTituloLista((TextView) itemView.findViewById(R.id.tituloLista));
    }

    public TextView getTituloLista() {
        return tituloLista;
    }

    public void setTituloLista(TextView tituloLista) {
        this.tituloLista = tituloLista;
    }

    public LinearLayout getListaItens() {
        return listaItens;
    }

    public void setListaItens(LinearLayout listaItens) {
        this.listaItens = listaItens;
    }
}
