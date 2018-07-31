package com.example.luca.prae_app.models;

import com.google.gson.annotations.SerializedName;

public class Paragrafo {

    @SerializedName("id")
    private int id;

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("texto")
    private String texto;

    @SerializedName("secao_id")
    private int secaoId;

    private Lista[] listas;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lista[] getListas() {
        return listas;
    }

    public void setListas(Lista[] listas) {
        this.listas = listas;
    }
}
