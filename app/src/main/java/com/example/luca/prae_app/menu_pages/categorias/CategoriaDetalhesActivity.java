package com.example.luca.prae_app.menu_pages.categorias;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Documento;
import com.example.luca.prae_app.models.Secao;
import com.example.luca.prae_app.providers.DocumentosWebServiceProvider;
import com.example.luca.prae_app.providers.SecoesWebServiceProvider;
import com.example.luca.prae_app.view.listeners.DocumentosClickListener;
import com.example.luca.prae_app.view.listeners.SecaoClickListener;

import java.util.concurrent.ExecutionException;

public class CategoriaDetalhesActivity extends AppCompatActivity {


    private SecoesWebServiceProvider secoesWebServiceProvider;
    private DocumentosWebServiceProvider documentosWebServiceProvider;
    private LinearLayout listaSecoes;
    private LinearLayout listaDocumentos;
    private TextView secoesTextView;
    private TextView documentosTextView;
    private Secao[] secoes;
    private Documento[] documentos;
    private int categoriaId;
    private String categoriaNome;
    private String categoriaDescricao;

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

    public void construirActivity(){

        try {

            getSupportActionBar().setTitle(this.categoriaNome);

            TextView descricao = findViewById(R.id.descricao);

            descricao.setText(this.categoriaDescricao);

            this.secoes = this.secoesWebServiceProvider.execute().get();
            this.documentos = this.documentosWebServiceProvider.execute().get();

            if (this.secoes != null && this.secoes.length > 0) {

                this.listaSecoes = findViewById(R.id.listaSecoes);
                this.listaDocumentos = findViewById(R.id.listaDocumentos);

                for (Secao s : this.secoes) {
                    View v = LayoutInflater.from(this).inflate(R.layout.item_lista_secoes, this.listaSecoes, false);
                    if (v.getParent() != null) {
                        ((ViewGroup) v.getParent()).removeView(v);
                    }
                    Button b = v.findViewById(R.id.botaoSecao);
                    b.setText(s.getNome());
                    b.setOnClickListener(new SecaoClickListener(this.getApplicationContext(),s));
                    this.listaSecoes.addView(v);
                }

                for (Documento d : this.documentos) {
                    View v = LayoutInflater.from(this).inflate(R.layout.item_lista_secoes, this.listaDocumentos, false);
                    if (v.getParent() != null) {
                        ((ViewGroup) v.getParent()).removeView(v);
                    }
                    Button b = v.findViewById(R.id.botaoSecao);
                    b.setText(d.getNome());
                    Drawable drawable = getResources().getDrawable(android.R.drawable.stat_sys_download);
                    drawable.setColorFilter(getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_ATOP);
                    drawable.setBounds(0, 0, 50, 50);
                    b.setCompoundDrawables(drawable, null, null, null);
                    b.setOnClickListener(new DocumentosClickListener(this.getApplicationContext(),d));
                    this.listaDocumentos.addView(v);
                }

                if(this.documentos == null || this.documentos.length == 0){

                    this.documentosTextView = findViewById(R.id.documentos);
                    this.listaDocumentos = findViewById(R.id.listaDocumentos);

                    this.documentosTextView.setVisibility(View.GONE);
                    this.listaDocumentos.setVisibility(View.GONE);

                }



            } else {

                this.documentosTextView = findViewById(R.id.documentos);
                this.listaSecoes = findViewById(R.id.listaSecoes);
                this.listaDocumentos = findViewById(R.id.listaDocumentos);

                this.documentosTextView.setVisibility(View.GONE);
                this.listaSecoes.setVisibility(View.GONE);
                this.listaDocumentos.setVisibility(View.GONE);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    public SecoesWebServiceProvider getSecoesWebServiceProvider() {
        return secoesWebServiceProvider;
    }

    public void setSecoesWebServiceProvider(SecoesWebServiceProvider secoesWebServiceProvider) {
        this.secoesWebServiceProvider = secoesWebServiceProvider;
    }

    public DocumentosWebServiceProvider getDocumentosWebServiceProvider() {
        return documentosWebServiceProvider;
    }

    public void setDocumentosWebServiceProvider(DocumentosWebServiceProvider documentosWebServiceProvider) {
        this.documentosWebServiceProvider = documentosWebServiceProvider;
    }

    public LinearLayout getListaSecoes() {
        return listaSecoes;
    }

    public void setListaSecoes(LinearLayout listaSecoes) {
        this.listaSecoes = listaSecoes;
    }

    public LinearLayout getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(LinearLayout listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    public TextView getSecoesTextView() {
        return secoesTextView;
    }

    public void setSecoesTextView(TextView secoesTextView) {
        this.secoesTextView = secoesTextView;
    }

    public TextView getDocumentosTextView() {
        return documentosTextView;
    }

    public void setDocumentosTextView(TextView documentosTextView) {
        this.documentosTextView = documentosTextView;
    }

    public Secao[] getSecoes() {
        return secoes;
    }

    public void setSecoes(Secao[] secoes) {
        this.secoes = secoes;
    }

    public Documento[] getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documento[] documentos) {
        this.documentos = documentos;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public String getCategoriaDescricao() {
        return categoriaDescricao;
    }

    public void setCategoriaDescricao(String categoriaDescricao) {
        this.categoriaDescricao = categoriaDescricao;
    }

}
