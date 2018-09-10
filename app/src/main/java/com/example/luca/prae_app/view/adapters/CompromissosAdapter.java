package com.example.luca.prae_app.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Compromisso;
import com.example.luca.prae_app.view.view_holders.CompromissoItemViewHolder;

public class CompromissosAdapter extends RecyclerView.Adapter<CompromissoItemViewHolder> {

    private Compromisso[] compromissos;

    public CompromissosAdapter(Compromisso[] compromissos){

        this.compromissos = compromissos;

    }

    @NonNull
    @Override
    public CompromissoItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.atividade_item_view,viewGroup,false);

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
