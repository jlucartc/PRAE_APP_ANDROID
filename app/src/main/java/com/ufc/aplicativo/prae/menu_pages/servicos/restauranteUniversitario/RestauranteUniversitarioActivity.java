package com.ufc.aplicativo.prae.menu_pages.servicos.restauranteUniversitario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.view.listeners.LinkClickListener;

public class RestauranteUniversitarioActivity extends AppCompatActivity {

    private String nome;
    private String descricao;
    private String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_servico_detalhes);

        TextView nomeTV = findViewById(R.id.nome);
        TextView descricaoTV = findViewById(R.id.descricao);
        link = "http://www.prae.ufc.br/restaurante-universitario";
        Button linkB = findViewById(R.id.link);

        nomeTV.setText("Restaurante Universitário");
        descricaoTV.setText("Garantir a alimentação àqueles estudantes que se encontram em situação de vulnerabilidade econômica comprovada com intuito de minimizar os efeitos das desigualdades sociais na permanência desse jovens na Universidade\n");

        linkB.setOnClickListener(new LinkClickListener(this.link));


    }
}
