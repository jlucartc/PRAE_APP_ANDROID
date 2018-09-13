package com.example.luca.prae_app.view.adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private Context context;

    public CategoriasAdapter(Categoria[] categorias){

        this.categorias = categorias;

    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categoria_item_layout,viewGroup,false);

        Button b = v.findViewById(R.id.botaoBolsa);

        this.context = viewGroup.getContext();

        return new CategoriaViewHolder(v);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder categoriaViewHolder, int i) {

        Log.i("CategoriasAdapter",String.valueOf(i));

        Log.i("CategoriasAdapter",String.valueOf(this.getCategorias()[i].getNome()));

        categoriaViewHolder.getBotaoBolsa().setText((this.getCategorias())[i].getNome());

        categoriaViewHolder.getBotaoBolsa().setOnClickListener(new CategoriaClickListener(this.context,(this.getCategorias())[i]));

        categoriaViewHolder.getBotaoBolsa().setTextColor(Color.parseColor("#1155ff"));

        categoriaViewHolder.getBotaoBolsa().setBackground(categoriaViewHolder.getBotaoBolsa().getResources().getDrawable(R.drawable.blue_white_button_selector));


    }

    @Override
    public int getItemCount() {
        return this.categorias.length;
    }

    public Categoria[] getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria[] categorias) {
        this.categorias = categorias;
    }
}
