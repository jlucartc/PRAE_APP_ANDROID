package com.example.luca.prae_app.models;

import com.google.gson.annotations.SerializedName;

public class Paragrafo {

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("texto")
    private String texto;

    @SerializedName("secao_id")
    private int secaoId;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getSecaoId() {
        return secaoId;
    }

    public void setSecaoId(int secaoId) {
        this.secaoId = secaoId;
    }
}
