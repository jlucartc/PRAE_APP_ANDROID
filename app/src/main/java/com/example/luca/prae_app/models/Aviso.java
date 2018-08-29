package com.example.luca.prae_app.models;

import com.google.gson.annotations.SerializedName;

public class Aviso {

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("mensagem")
    private String mensagem;

    @SerializedName("id")
    private int id;

    private Boolean isNovo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getNovo() {
        return isNovo;
    }

    public void setNovo(Boolean novo) {
        isNovo = novo;
    }
}
