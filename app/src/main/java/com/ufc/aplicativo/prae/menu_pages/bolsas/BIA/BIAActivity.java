package com.ufc.aplicativo.prae.menu_pages.bolsas.BIA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.view.listeners.LinkClickListener;

public class BIAActivity extends AppCompatActivity {


    private String nome;
    private String descricao;
    private String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bolsa_detalhes);


        TextView nomeTV = findViewById(R.id.nome);
        TextView descricaoTV = findViewById(R.id.descricao);
        this.link = "http://www.prae.ufc.br/bolsa-de-iniciacao-academica/";
        nomeTV.setText("Bolsa de iniciação Acadêmica");
        descricaoTV.setText("Ei! Você é novo aqui na UFC ou já é veterano dos cursos de graduação presenciais? Tem como comprovar sua situação de vulnerabilidade socioeconômica?\n" + "Se sua resposta foi sim, a Bolsa de Iniciação Acadêmica - BIA pode te ajudar! Você só precisa estar atento ao lançamento do edital que sai durante o início do ano.\n" + "Quer saber mais? Clica no link do nosso site e veja tudo sobre a BIA.\n");
        Button linkB = findViewById(R.id.link);

        linkB.setOnClickListener(new LinkClickListener(this.link));

    }
}
