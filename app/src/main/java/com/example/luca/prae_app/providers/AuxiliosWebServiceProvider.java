package com.example.luca.prae_app.providers;

import android.content.Context;

import com.example.luca.prae_app.R;

public class AuxiliosWebServiceProvider extends CategoriasWebServiceProvider {


    public AuxiliosWebServiceProvider(Context context) {

        super(context);

        setCategoriasUri(this.getContext().getResources().getString(R.string.localhost)+"/app/ws/categorias/2");

    }

}
