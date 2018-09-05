package com.example.luca.prae_app.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Aviso;
import com.example.luca.prae_app.view.listeners.AvisoClickListener;
import com.example.luca.prae_app.view.view_holders.AvisosViewHolder;

public class AvisosAdapter extends RecyclerView.Adapter<AvisosViewHolder> {
    @NonNull

    private Aviso[] avisos;
    private Context context;


    public AvisosAdapter(Aviso[] avisos, Context context){

        this.avisos = avisos;
        this.context = context;

    }

    @Override
    public AvisosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_aviso_layout,viewGroup,false);

        v.setOnClickListener(new AvisoClickListener());

        AvisosViewHolder vh = new AvisosViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull AvisosViewHolder avisosViewHolder, int i) {


        avisosViewHolder.getAvisoMensagem().setText(this.avisos[i].getTitulo());
        avisosViewHolder.getId().setText(String.valueOf(this.avisos[i].getId()));
        avisosViewHolder.getLink().setText(this.avisos[i].getLink());

        if(this.avisos[i].getNovo() == true){

            avisosViewHolder.getStatusAviso().setVisibility(View.VISIBLE);

        }else{

            avisosViewHolder.getStatusAviso().setVisibility(View.INVISIBLE);

        }

    }

    @Override
    public int getItemCount() {
        return this.avisos.length;
    }
}
