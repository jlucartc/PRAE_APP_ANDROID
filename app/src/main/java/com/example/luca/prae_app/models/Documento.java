package com.example.luca.prae_app.models;

import com.google.gson.annotations.SerializedName;

public class Documento {

    @SerializedName("nome")
    private String nome;

    @SerializedName("rota")
    private String rota;

    @SerializedName("categoria_id")
    private int categoriaId;

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

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
}
