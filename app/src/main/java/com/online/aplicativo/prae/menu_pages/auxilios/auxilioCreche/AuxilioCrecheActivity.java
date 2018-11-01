package com.online.aplicativo.prae.menu_pages.auxilios.auxilioCreche;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.online.aplicativo.prae.R;
import com.online.aplicativo.prae.view.listeners.LinkClickListener;

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
        descricaoTV.setText("É destinado a mães ou pais de crianças entre 6 e 48 meses de idade incompletos, que estão em situação de vulnerabilidade socioeconômica, que tenham guarda e que morem com filhos(as). Quer saber mais sobre esse auxílio? Corre lá e entra no site da PRAE para ficar por dentro de tudo!");
        linkB.setOnClickListener(new LinkClickListener(this.link));

    }
}
