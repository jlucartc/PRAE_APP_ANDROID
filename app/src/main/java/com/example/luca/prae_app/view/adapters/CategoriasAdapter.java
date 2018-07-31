package com.example.luca.prae_app.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Categoria;
import com.example.luca.prae_app.view.listeners.CategoriaClickListener;
import com.example.luca.prae_app.view.view_holders.CategoriaViewHolder;

public class CategoriasAdapter extends RecyclerView.Adapter<CategoriaViewHolder> {


    private Categoria[] categorias;

    public CategoriasAdapter(Categoria[] categorias){

        this.categorias = categorias;

    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bolsa_item_layout,viewGroup,false);

        Button b = v.findViewById(R.id.botaoBolsa);
        b.setOnClickListener(new CategoriaClickListener(viewGroup.getContext(),this.getCategorias()[i]));

        return new CategoriaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder categoriaViewHolder, int i) {

        categoriaViewHolder.getBotaoBolsa().setText(this.getCategorias()[i].getNome());

    }

    @Override
    public int getItemCount() {
        return this.getCategorias().length;
    }

    public Categoria[] getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria[] categorias) {
        this.categorias = categorias;
    }
}
