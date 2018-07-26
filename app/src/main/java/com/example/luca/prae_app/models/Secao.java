package com.example.luca.prae_app.models;

import com.google.gson.annotations.SerializedName;

public class Secao {

    @SerializedName("nome")
    private String nome;

    @SerializedName("categoria_id")
    private int categoriaId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

}
