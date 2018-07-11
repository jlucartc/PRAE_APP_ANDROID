package com.example.luca.prae_app;

import com.google.gson.annotations.SerializedName;

public class Noticia {

    @SerializedName("id")
    private int id;

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("guid")
    private String guid;

    private boolean isNova;

    Noticia(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
