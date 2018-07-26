package com.example.luca.prae_app.providers;

import android.content.Context;

import com.example.luca.prae_app.R;

public class BolsasWebServiceProvider extends CategoriasWebServiceProvider {

    public BolsasWebServiceProvider(Context context) {
        super(context);

        setCategoriasUri(this.getContext().getResources().getString(R.string.localhost)+"/app/ws/categorias/1");

    }


}
