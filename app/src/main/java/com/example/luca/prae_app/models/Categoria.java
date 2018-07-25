package com.example.luca.prae_app.models;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

public class Categoria {

    @SerializedName("nome")
    private String nome;

    @SerializedName("tipo_categoria")
    private int tipoCategoria;

    @SerializedName("responsavel")
    private String responsavel;

    @SerializedName("email")
    private String email;

    @SerializedName("fone")
    private String fone;

    @SerializedName("rua")
    private String rua;

    @SerializedName("numero")
    private String numero;

    @SerializedName("bairro")
    private String bairro;

    private JSONArray secoes;

    private JSONArray documentos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(int tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public JSONArray getSecoes() {
        return secoes;
    }

    public void setSecoes(JSONArray secoes) {
        this.secoes = secoes;
    }

    public JSONArray getDocumentos() {
        return documentos;
    }

    public void setDocumentos(JSONArray documentos) {
        this.documentos = documentos;
    }
}
