package com.example.luca.prae_app.menu_pages.categorias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Categoria;
import com.example.luca.prae_app.providers.CategoriasWebServiceProvider;
import com.example.luca.prae_app.view.adapters.CategoriasAdapter;

import java.util.concurrent.ExecutionException;

public class CategoriasActivity extends AppCompatActivity {

    private RecyclerView categoriasRecyclerView;
    private RecyclerView.LayoutManager layoutManager ;
    private CategoriasAdapter categoriasAdapter;
    private CategoriasWebServiceProvider categoriasWebServiceProvider;
    private Categoria[] categorias;
    private String categoriaUri;
    private int tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        this.setTipo(getIntent().getIntExtra("tipo",0));

        switch(this.getTipo()){
            case 1:
                this.getSupportActionBar().setTitle("Bolsas");
                break;
            case 2:
                this.getSupportActionBar().setTitle("Auxílios");
                break;
            case 3:
                this.getSupportActionBar().setTitle("Serviços");
                break;
        }

        this.categoriasWebServiceProvider = new CategoriasWebServiceProvider(this.getApplicationContext(),this.getTipo());

        try {
            this.categorias = (Categoria[])this.categoriasWebServiceProvider.execute().get();

            if(this.categorias != null && this.categorias.length > 0){


                this.setContentView(R.layout.activity_categorias);

                this.categoriasRecyclerView = findViewById(R.id.categoriasRecyclerView);

                this.layoutManager = new LinearLayoutManager(this.getApplicationContext());

                this.categoriasAdapter = new CategoriasAdapter(this.categorias);

                this.categoriasRecyclerView.setLayoutManager(this.layoutManager);

                this.categoriasRecyclerView.setAdapter(this.categoriasAdapter);


            }else{

                this.setContentView(R.layout.nao_encontrado);

                TextView aviso = findViewById(R.id.aviso);

                switch(this.getTipo()){
                    case 1:
                        aviso.setText("Sem bolsas no momento");
                        break;
                    case 2:
                        aviso.setText("Sem auxilios no momento");
                        break;
                    case 3:
                        aviso.setText("Sem serviços no momento");
                        break;
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public RecyclerView getCategoriasRecyclerView() {
        return categoriasRecyclerView;
    }

    public void setCategoriasRecyclerView(RecyclerView categoriasRecyclerView) {
        this.categoriasRecyclerView = categoriasRecyclerView;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public CategoriasAdapter getCategoriasAdapter() {
        return categoriasAdapter;
    }

    public void setCategoriasAdapter(CategoriasAdapter categoriasAdapter) {
        this.categoriasAdapter = categoriasAdapter;
    }

    public CategoriasWebServiceProvider getCategoriasWebServiceProvider() {
        return categoriasWebServiceProvider;
    }

    public void setCategoriasWebServiceProvider(CategoriasWebServiceProvider categoriasWebServiceProvider) {
        this.categoriasWebServiceProvider = categoriasWebServiceProvider;
    }

    public Categoria[] getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria[] categorias) {
        this.categorias = categorias;
    }

    public String getCategoriaUri() {
        return categoriaUri;
    }

    public void setCategoriaUri(String categoriaUri) {
        this.categoriaUri = categoriaUri;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
