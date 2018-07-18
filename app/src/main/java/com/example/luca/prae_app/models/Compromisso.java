package com.example.luca.prae_app.models;

import com.google.gson.annotations.SerializedName;

public class Compromisso {

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("data")
    private String data;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
