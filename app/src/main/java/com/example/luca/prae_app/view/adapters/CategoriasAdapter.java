package com.example.luca.prae_app.view.adapters;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Categoria;
import com.example.luca.prae_app.view.listeners.CategoriaClickListener;
import com.example.luca.prae_app.view.view_holders.CategoriaViewHolder;

import static com.example.luca.prae_app.R.drawable.*;
import static com.example.luca.prae_app.R.drawable.blue_button_selector;

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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder categoriaViewHolder, int i) {

        categoriaViewHolder.getBotaoBolsa().setText(this.getCategorias()[i].getNome());

        if(this.getCategorias()[i].getTipoCategoria() == 1){

            // Bolsas

            categoriaViewHolder.getBotaoBolsa().setTextColor(Color.parseColor("#1155ff"));

            categoriaViewHolder.getBotaoBolsa().setBackground(categoriaViewHolder.getBotaoBolsa().getResources().getDrawable(R.drawable.blue_button_selector));

        }else if(this.getCategorias()[i].getTipoCategoria() == 2){

            // Auxilios

            categoriaViewHolder.getBotaoBolsa().setTextColor(Color.parseColor("#1155ff"));

            categoriaViewHolder.getBotaoBolsa().setBackground(categoriaViewHolder.getBotaoBolsa().getResources().getDrawable(R.drawable.blue_button_selector));


        }else if(this.getCategorias()[i].getTipoCategoria() == 3){

            // Serviços

            categoriaViewHolder.getBotaoBolsa().setTextColor(Color.parseColor("#1155ff"));

            categoriaViewHolder.getBotaoBolsa().setBackground(categoriaViewHolder.getBotaoBolsa().getResources().getDrawable(R.drawable.blue_button_selector));


        }

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
