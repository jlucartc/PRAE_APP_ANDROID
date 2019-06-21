package com.ufc.aplicativo.prae.menu_pages.auxilios.auxilioEmergencial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.view.listeners.LinkClickListener;

public class AuxilioEmergencialActivity extends AppCompatActivity {

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

        nomeTV.setText("Auxílio Emergencial");
        descricaoTV.setText("Você é estudante de graduação, está em situação de vulnerabilidade socioeconômica comprovada e não é beneficiado por outras ações de apoio financeiro disponíveis na UFC ou estágio?" +
                " Sim?\n" +
                "Esse auxílio tem o intuito de ajudar no desempenho acadêmico satisfatório e a finalidade de reduzir o risco de evasão, propiciando a  conclusão dos cursos em tempo hábil.\n");


        linkB.setOnClickListener(new LinkClickListener(this.link));

    }
}
