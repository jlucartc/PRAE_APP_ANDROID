package com.online.aplicativo.prae.models;

import com.google.gson.annotations.SerializedName;

public class Compromisso {

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("data")
    private String data;

    @SerializedName("local")
    private String local;

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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
