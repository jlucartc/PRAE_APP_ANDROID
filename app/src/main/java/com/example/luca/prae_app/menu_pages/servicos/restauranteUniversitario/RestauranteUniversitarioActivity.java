package com.example.luca.prae_app.menu_pages.servicos.restauranteUniversitario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.view.listeners.LinkClickListener;

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

        nomeTV.setText("Isenção do Restaurante Universitário");
        descricaoTV.setText("Garantir a alimentação àqueles estudantes que se encontram em situação de vulnerabilidade econômica comprovada com intuito de minimizar os efeitos das desigualdades sociais na permanência desse jovens na Universidade\n");

        linkB.setOnClickListener(new LinkClickListener(this.link));


    }
}
