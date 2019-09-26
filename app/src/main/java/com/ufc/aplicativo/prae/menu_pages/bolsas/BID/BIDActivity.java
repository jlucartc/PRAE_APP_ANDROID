package com.ufc.aplicativo.prae.menu_pages.bolsas.BID;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.view.listeners.LinkClickListener;

public class BIDActivity extends AppCompatActivity {

    private String nome;
    private String descricao;
    private String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bolsa_detalhes);


        TextView nomeTV = findViewById(R.id.nome);
        TextView descricaoTV = findViewById(R.id.descricao);
        this.link = "http://www.prae.ufc.br/bolsa-de-incentivo-ao-desporto/";
        Button linkB = findViewById(R.id.link);
        nomeTV.setText("Bolsa de Incentivo ao Desporto");
        descricaoTV.setText("Ei! Você tem interesse em desenvolver suas capacidades em atividades relacionadas ao desporto? Se tem interesse, então o Programa Bolsa de Incentivo ao Desporto, pode ser uma boa opção, pois  contribui na melhoria da sua trajetória e formação acadêmica.\n" + "Saiba mais clicando no link.\n");

        linkB.setOnClickListener(new LinkClickListener(this.link));

    }
}
