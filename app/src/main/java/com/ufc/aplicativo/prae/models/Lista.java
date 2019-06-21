package com.ufc.aplicativo.prae.models;

import com.google.gson.annotations.SerializedName;

public class Lista {

    @SerializedName("nome")
    private String nome;

    @SerializedName("paragrafo_id")
    private int paragrafoId;

    private Item[] itens;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getParagrafoId() {
        return paragrafoId;
    }

    public void setParagrafoId(int paragrafoId) {
        this.paragrafoId = paragrafoId;
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }
}
