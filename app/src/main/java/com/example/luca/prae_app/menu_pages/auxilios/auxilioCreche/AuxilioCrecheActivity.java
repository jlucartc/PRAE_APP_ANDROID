package com.example.luca.prae_app.menu_pages.auxilios.auxilioCreche;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.view.listeners.LinkClickListener;

public class AuxilioCrecheActivity extends AppCompatActivity {

    private String nome;
    private String descricao;
    private String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_auxilio_detalhes);

        TextView nomeTV = findViewById(R.id.nome);
        TextView descricaoTV = findViewById(R.id.descricao);
        link = "http://www.prae.ufc.br/auxilio-moradia";
        Button linkB = findViewById(R.id.link);

        nomeTV.setText("Auxílio Creche");
        descricaoTV.setText("É destinado a mães ou pais de crianças entre 6 e 48 meses de idade incompletos, que estão em situação de vulnerabilidade socioeconômica, que tenham guarda e que morem com filhos(as). Quer saber mais sobre esse auxilio? Corre lá e entra no site da PRAE pra ficar por dentro de tudo!\n" + "\n" + "que se encontrem em situação de vulnerabilidade socioeconômica, Página 1 de 10 que detenham guarda, e que coabitem com filhos(as) em idade entre 6 (seis) e 48 (quarenta e oito) meses incompletos,\n" + "\n" + "Tem o objetivo de contribuir nas despesas de cuidados com a criança com o intuito de proporcionar a frequência regular às aulas, o desempenho acadêmico satisfatório e a conclusão em tempo hábil de seu curso de graduação.\n");


        linkB.setOnClickListener(new LinkClickListener(this.link));

    }
}
