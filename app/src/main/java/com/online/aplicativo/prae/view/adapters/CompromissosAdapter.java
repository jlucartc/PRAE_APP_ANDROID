package com.online.aplicativo.prae.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.online.aplicativo.prae.R;
import com.online.aplicativo.prae.models.Compromisso;
import com.online.aplicativo.prae.view.view_holders.CompromissoItemViewHolder;

public class CompromissosAdapter extends RecyclerView.Adapter<CompromissoItemViewHolder> {

    private Compromisso[] compromissos;

    public CompromissosAdapter(Compromisso[] compromissos){

        this.compromissos = compromissos;

    }

    @NonNull
    @Override
    public CompromissoItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.atividades_item_view,viewGroup,false);

        CompromissoItemViewHolder comp = new CompromissoItemViewHolder(v);

        return comp;

    }

    @Override
    public void onBindViewHolder(@NonNull CompromissoItemViewHolder viewHolder, int i) {

        viewHolder.getTitulo().setText(this.compromissos[i].getTitulo());
        viewHolder.getHorario().setText(this.compromissos[i].getData());
        viewHolder.getLocal().setText(this.compromissos[i].getLocal());

    }

    @Override
    public int getItemCount() {
        return this.compromissos.length;
    }
}
