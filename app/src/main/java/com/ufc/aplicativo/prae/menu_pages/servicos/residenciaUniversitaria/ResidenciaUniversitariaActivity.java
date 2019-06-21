package com.ufc.aplicativo.prae.menu_pages.servicos.residenciaUniversitaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.view.listeners.LinkClickListener;

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
        descricaoTV.setText("Passou na UFC e mora no interior do Ceará, ou em outros estados?\n" +
                "Sabia que a universidade possui residências, onde os estudantes em situação de vulnerabilidade econômica podem concorrer a uma vaga?\n" +
                "Pois é, fique atento aos editais que são lançados anualmente no site da PRAE.\n");
        linkB.setOnClickListener(new LinkClickListener(this.link));


    }
}
