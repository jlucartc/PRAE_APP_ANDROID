package com.ufc.aplicativo.prae.view.view_holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;

public class AvisosViewHolder extends RecyclerView.ViewHolder {

    public TextView avisoMensagem;
    public TextView titulo;
    public TextView tituloLink;
    public TextView statusAviso;
    public TextView link;
    public TextView id;

    public AvisosViewHolder(@NonNull View itemView) {
        super(itemView);

        this.titulo = itemView.findViewById(R.id.titulo);
        this.tituloLink = itemView.findViewById(R.id.tituloLink);
        this.avisoMensagem = itemView.findViewById(R.id.mensagemAviso);
        this.statusAviso = itemView.findViewById(R.id.statusAviso);
        this.link = itemView.findViewById(R.id.avisoUrl);
        this.id = itemView.findViewById(R.id.avisoId);

    }

    public TextView getAvisoMensagem() {
        return avisoMensagem;
    }

    public void setAvisoMensagem(TextView avisoMensagem) {
        this.avisoMensagem = avisoMensagem;
    }

    public TextView getStatusAviso() {
        return statusAviso;
    }

    public void setStatusAviso(TextView statusAviso) {
        this.statusAviso = statusAviso;
    }

    public TextView getLink() { return this.link; }

    public void setLink(TextView url) {
        this.link = url;
    }

    public TextView getId() {
        return id;
    }

    public void setId(TextView id) {
        this.id = id;
    }

    public TextView getTitulo() {
        return titulo;
    }

    public void setTitulo(TextView titulo) {
        this.titulo = titulo;
    }

    public TextView getTituloLink() {
        return tituloLink;
    }

    public void setTituloLink(TextView tituloLink) {
        this.tituloLink = tituloLink;
    }
}


