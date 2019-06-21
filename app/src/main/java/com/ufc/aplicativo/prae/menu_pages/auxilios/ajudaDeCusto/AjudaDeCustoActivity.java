package com.ufc.aplicativo.prae.menu_pages.auxilios.ajudaDeCusto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.view.listeners.LinkClickListener;

public class AjudaDeCustoActivity extends AppCompatActivity {

    private String nome;
    private String descricao;
    private String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_auxilio_detalhes);

        TextView nomeTV = findViewById(R.id.nome);
        TextView descricaoTV = findViewById(R.id.descricao);
        link = "http://www.prae.ufc.br/ajuda-de-custo/";
        Button linkB = findViewById(R.id.link);

        nomeTV.setText("Ajuda de Custo");
        descricaoTV.setText("Uau! Vai apresentar trabalho acadêmico em outro estado, mas não tem condições financeiras?\n" + "A PRAE pode te ajudar! Nós disponibilizamos uma ajuda de custo para que você possa apresentar seu trabalho sem ser prejudicado!\n" + "Para mais informações e consultar valores que constam em nossa tabela, acesse o link abaixo:\n");

        linkB.setOnClickListener(new LinkClickListener(this.link));

    }
}
