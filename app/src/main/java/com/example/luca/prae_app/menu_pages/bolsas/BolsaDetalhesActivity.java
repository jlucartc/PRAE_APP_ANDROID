package com.example.luca.prae_app.menu_pages.bolsas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Documento;
import com.example.luca.prae_app.models.Secao;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BolsaDetalhesActivity extends AppCompatActivity {

    private Secao[] secoes;
    private JSONObject documentos;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolsa_detalhes);

        this.gson = new Gson();

        try {

            JSONArray secoesJSON = new JSONArray(this.getIntent().getStringExtra("secoes"));
            JSONArray documentosJSON = new JSONArray(this.getIntent().getStringExtra("documentos"));

            this.secoes = new Secao[secoesJSON.length()];
            this.documentos = new Documento[documentosJSON.length()];

            for(int i = 0; i < secoesJSON.length(); i++){

                JSONObject obj = secoesJSON.getJSONObject(i);

                this.secoes[i] = gson.fromJson(obj.toString(),Secao.class);

            }

            for(int i = 0; i < documentosJSON.length(); i++){

                JSONObject obj = documentosJSON.getJSONObject(i);

                this.documentos[i] = gson.fromJson(obj.toString(),Documento.class);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }




    }
}
