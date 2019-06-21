package com.ufc.aplicativo.prae.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.models.Mapa;
import com.ufc.aplicativo.prae.view.listeners.MapaItemClickListener;
import com.ufc.aplicativo.prae.view.view_holders.MapaItemViewHolder;

public class MapasAdapter extends RecyclerView.Adapter<MapaItemViewHolder> {

    private Mapa[] mapas;

    public MapasAdapter(Mapa[] mapas){

        this.mapas = mapas;

    }

    @NonNull
    @Override
    public MapaItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mapa_item_layout,viewGroup,false);

        v.setOnClickListener(new MapaItemClickListener(viewGroup.getContext(),this.mapas[i].getId()));

        MapaItemViewHolder vh = new MapaItemViewHolder(v);

        //TextView t = new TextView(viewGroup.getContext());

        //t.setText(viewGroup.getContext().getResources().getString(R.string.localhost));

        //vh.setRota(t);

        return vh;

    }


    @Override
    public void onBindViewHolder(@NonNull MapaItemViewHolder mapaItemViewHolder, int i) {

        mapaItemViewHolder.getNome().setContentDescription("Nome do mapa");
        mapaItemViewHolder.getNome().setText(this.mapas[i].getNome());
        mapaItemViewHolder.getRota().setText("/mostrarMapa/"+this.mapas[i].getId());

    }

    @Override
    public int getItemCount() {
        return this.mapas.length;
    }
}
