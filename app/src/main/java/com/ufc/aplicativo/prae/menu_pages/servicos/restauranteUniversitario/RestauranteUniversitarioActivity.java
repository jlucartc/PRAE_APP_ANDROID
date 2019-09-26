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
        link = "http://www.ufc.br/restaurante";
        Button linkB = findViewById(R.id.link);
        linkB.setText("IR PARA O SITE");
        nomeTV.setText("Restaurante Universitário");
        descricaoTV.setText("O Programa de Restaurante Universitário tem por objetivo oferecer refeição balanceada e de qualidade a estudantes, docentes, servidores técnico-administrativos da UFC e pessoal a serviço da UFC de empresas terceirizadas contratadas, além de constituir um espaço de convivência e integração da comunidade universitária.\n");

        linkB.setOnClickListener(new LinkClickListener(this.link));


    }
}
