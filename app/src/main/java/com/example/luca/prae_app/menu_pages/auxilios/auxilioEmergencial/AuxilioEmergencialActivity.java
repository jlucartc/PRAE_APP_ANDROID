package com.example.luca.prae_app.menu_pages.auxilios.auxilioEmergencial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.view.listeners.LinkClickListener;

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
        descricaoTV.setText("Disponibiliza ajuda financeira, em caráter de eventualidade, a estudantes de graduação, em situação de vulnerabilidade socioeconômica comprovada e que não tenha alcançado por nenhuma de outras ações de apoio financeiro disponíveis na UFC ou pagas com recursos do Governo Federal de modo que possa contribuir para a obtenção de um desempenho acadêmico satisfatório, reduzir o risco de evasão e de propiciar conclusão dos cursos em tempo hábil.\n");


        linkB.setOnClickListener(new LinkClickListener(this.link));

    }
}
