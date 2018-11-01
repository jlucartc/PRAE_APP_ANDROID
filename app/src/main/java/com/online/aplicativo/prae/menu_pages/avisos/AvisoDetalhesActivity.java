package com.online.aplicativo.prae.menu_pages.avisos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.online.aplicativo.prae.R;
import com.online.aplicativo.prae.view.listeners.AvisoLinkClickListener;

public class AvisoDetalhesActivity extends AppCompatActivity {

    private TextView avisoMensagem;
    private TextView titulo;
    private String url;
    private Button link;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviso_detalhes);

        //getSupportActionBar().setTitle(getIntent().getStringExtra("titulo"));

        this.link = findViewById(R.id.botao_link);
        this.avisoMensagem = findViewById(R.id.avisoMensagem);
        this.titulo = findViewById(R.id.titulo);

        this.avisoMensagem.setText(getIntent().getStringExtra("avisoMensagem"));
        this.titulo.setText(getIntent().getStringExtra("titulo"));
        this.url = getIntent().getStringExtra("url");

        this.link.setOnClickListener(new AvisoLinkClickListener(this.url));
    }
}
