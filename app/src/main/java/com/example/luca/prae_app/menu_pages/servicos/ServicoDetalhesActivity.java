package com.example.luca.prae_app.menu_pages.servicos;

import android.os.Bundle;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.menu_pages.categorias.CategoriaDetalhesActivity;
import com.example.luca.prae_app.providers.DocumentosWebServiceProvider;
import com.example.luca.prae_app.providers.SecoesWebServiceProvider;

public class ServicoDetalhesActivity extends CategoriaDetalhesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categoria_detalhes);

        this.setCategoriaId(getIntent().getIntExtra("categoriaId",0));
        this.setCategoriaNome(getIntent().getStringExtra("nome"));
        this.setCategoriaDescricao(getIntent().getStringExtra("descricao"));
        this.setSecoesWebServiceProvider(new SecoesWebServiceProvider(this.getApplicationContext(),this.getCategoriaId()));
        this.setDocumentosWebServiceProvider(new DocumentosWebServiceProvider(this.getApplicationContext(),this.getCategoriaId()));

        this.construirActivity();
    }
}