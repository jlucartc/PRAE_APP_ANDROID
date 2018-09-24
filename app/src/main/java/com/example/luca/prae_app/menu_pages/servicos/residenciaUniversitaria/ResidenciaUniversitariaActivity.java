package com.example.luca.prae_app.menu_pages.servicos.residenciaUniversitaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.view.listeners.LinkClickListener;

public class ResidenciaUniversitariaActivity extends AppCompatActivity {

    private String nome;
    private String descricao;
    private String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_servico_detalhes);

        TextView nomeTV = findViewById(R.id.nome);
        TextView descricaoTV = findViewById(R.id.descricao);
        link = "http://www.prae.ufc.br/residencia-universitaria/";
        Button linkB = findViewById(R.id.link);

        nomeTV.setText("Residência Universitária");
        descricaoTV.setText("Propiciar a permanência do estudante em situação de vulnerabilidade econômica, vindo do interior do estado, ou de outros estados, assegurando-lhe moradia, alimentação e apoio psicossocial.");
        linkB.setOnClickListener(new LinkClickListener(this.link));


    }
}
