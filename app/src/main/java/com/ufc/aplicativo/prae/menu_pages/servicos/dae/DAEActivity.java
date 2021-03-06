package com.ufc.aplicativo.prae.menu_pages.servicos.dae;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.view.listeners.LinkClickListener;

public class DAEActivity extends AppCompatActivity {

    private String nome;
    private String descricao;
    private String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_servico_detalhes);

        TextView nomeTV = findViewById(R.id.nome);
        TextView descricaoTV = findViewById(R.id.descricao);
        link = "http://www.prae.ufc.br/acompanhamento-psicopedagogico-psicologico-e-psicossocial/";
        Button linkB = findViewById(R.id.link);

        nomeTV.setText("Atendimento ao Estudante");
        descricaoTV.setText("Você está passando por dificuldades no âmbito acadêmico, emocional ou social?\n" +
                "A PRAE tem uma divisão exclusiva para atender os alunos que estão com essas dificuldades. Aqui você pode ter acompanhamento Psicopedagógico, Psicológico e Psicossocial com profissionais capacitados da Divisão de Atenção ao Estudande. \n" +
                "Para mais informações clique no link abaixo.\n");
        linkB.setOnClickListener(new LinkClickListener(this.link));


    }
}
