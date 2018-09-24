package com.example.luca.prae_app.menu_pages.auxilios.auxilioMoradia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.view.listeners.LinkClickListener;

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
        descricaoTV.setText("Objetivo: viabilizar a permanência de estudantes do cursos de graduação, em comprovada situação de vulnerabilidade econômica.\n" + "obs: não impede de receber outra bolsa de programas da UFC.\n");


        linkB.setOnClickListener(new LinkClickListener(this.link));

    }
}
