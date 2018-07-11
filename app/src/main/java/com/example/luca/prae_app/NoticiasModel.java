package com.example.luca.prae_app;

import android.arch.lifecycle.ViewModel;

public class NoticiasModel extends ViewModel {

    private Noticia[] noticias;

    public Noticia[] getNoticias(){

        return this.noticias;

    }

    public void setNoticias(Noticia[] noticias ){

        this.noticias = noticias;

    }

}
