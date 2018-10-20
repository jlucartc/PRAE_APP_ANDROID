package com.example.luca.prae_app.menu_pages.servicos.dap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.view.listeners.LinkClickListener;

public class DAPActivity extends AppCompatActivity {

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

        nomeTV.setText("DAP - Divisão de Apoio ao Estudante");
        descricaoTV.setText("Você está passando por dificuldades no âmbito acadêmico, emocional ou social?\n" +
                "A PRAE tem uma divisão exclusiva para atender os alunos que estão com essas dificuldades. Aqui você pode ter acompanhamento Psicopedagógico, Psicológico e Psicossocial com profissionais capacitados. \n" +
                "Para mais informações clique no link abaixo.\n");
        linkB.setOnClickListener(new LinkClickListener(this.link));


    }
}
