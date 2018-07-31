package com.example.luca.prae_app.models;

import com.google.gson.annotations.SerializedName;

public class Mapa {

    @SerializedName("nome")
    private String nome;

    @SerializedName("rota")
    private String rota;

    @SerializedName("id")
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
