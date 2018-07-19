package com.example.luca.prae_app.view.view_holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.luca.prae_app.R;

public class MapaItemViewHolder extends RecyclerView.ViewHolder {

    private TextView nome;
    private TextView rota;

    public MapaItemViewHolder(@NonNull View itemView) {
        super(itemView);

        this.nome = itemView.findViewById(R.id.nome);
        this.rota = itemView.findViewById(R.id.rota);

    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getRota() {
        return rota;
    }

    public void setRota(TextView rota) {
        this.rota = rota;
    }
}
