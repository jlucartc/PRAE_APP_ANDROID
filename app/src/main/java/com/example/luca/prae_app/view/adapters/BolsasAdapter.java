package com.example.luca.prae_app.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Categoria;
import com.example.luca.prae_app.view.listeners.BolsaClickListener;
import com.example.luca.prae_app.view.view_holders.BolsasViewHolder;

public class BolsasAdapter extends RecyclerView.Adapter<BolsasViewHolder> {

    private Categoria[] bolsas;

    public BolsasAdapter(Categoria[] bolsas){

        this.bolsas = bolsas;

    }

    @NonNull
    @Override
    public BolsasViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bolsa_item_layout,viewGroup,false);

        v.setOnClickListener(new BolsaClickListener(viewGroup.getContext()));

        return new BolsasViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull BolsasViewHolder bolsasViewHolder, int i) {

        bolsasViewHolder.getBotaoBolsa().setText(this.bolsas[i].getNome());

    }

    @Override
    public int getItemCount() {
        return this.bolsas.length;
    }
}
