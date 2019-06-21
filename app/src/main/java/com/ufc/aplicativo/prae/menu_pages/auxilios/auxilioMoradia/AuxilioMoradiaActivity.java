package com.ufc.aplicativo.prae.menu_pages.auxilios.auxilioMoradia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.view.listeners.LinkClickListener;

public class AuxilioMoradiaActivity extends AppCompatActivity {

    private String nome;
    private String descricao;
    private String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_auxilio_detalhes);


        TextView nomeTV = findViewById(R.id.nome);
        TextView descricaoTV = findViewById(R.id.descricao);
        link = "http://www.prae.ufc.br/auxilio-moradia/";
        Button linkB = findViewById(R.id.link);

        nomeTV.setText("Auxílio Moradia");
        descricaoTV.setText("Você reside em região metropolitana ou no interior e não foi contemplado com o Programa de Residência Universitária?\n" +
                "Não se reprima!!\n" +
                "Nós, da PRAE, disponibilizamos, o auxílio moradia que ajuda na permanência de estudantes dos cursos de graduação, que estão em situação de vulnerabilidade econômica.\n" +
                "obs: este auxílio não impede o estudante de receber outra bolsa de programas da UFC (único auxílio acumulativo).\n");


        linkB.setOnClickListener(new LinkClickListener(this.link));

    }
}
