package com.example.luca.prae_app.menu_pages.auxilios.isencaoDoRU;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.view.listeners.LinkClickListener;

public class IsencaoDoRUActivity extends AppCompatActivity {

    private String nome;
    private String descricao;
    private String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_auxilio_detalhes);

        TextView nomeTV = findViewById(R.id.nome);
        TextView descricaoTV = findViewById(R.id.descricao);
        link = "http://www.prae.ufc.br/restaurante-universitario";
        Button linkB = findViewById(R.id.link);

        nomeTV.setText("Isenção do Restaurante Universitário");
        descricaoTV.setText("Tá precisando se alimentar, porém tá sem grana até pra passagem.. Já pensou em ter acesso a melhor comida da UFC sem pagar nada?!\n" +
                "Você sabia que a PRAE tem um programa chamado Isenção do R.U que atende aos alunos que se encontram em situação de vulnerabilidade econômica comprovada?\n" +
                "Então é só ficar atento ao edital da isenção que é unificado com outros auxílios da PRAE que são lançados semestralmente no site.\n");


        linkB.setOnClickListener(new LinkClickListener(this.link));

    }
}
