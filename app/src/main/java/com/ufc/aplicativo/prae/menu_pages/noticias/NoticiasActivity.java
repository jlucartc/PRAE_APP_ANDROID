package com.ufc.aplicativo.prae.menu_pages.noticias;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ufc.aplicativo.prae.models.Noticia;
import com.ufc.aplicativo.prae.view.adapters.NoticiasAdapter;
import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.providers.NoticiasWebServiceProvider;

import java.util.concurrent.ExecutionException;

public class NoticiasActivity extends AppCompatActivity {

    private Noticia[] noticias;
    private NoticiasWebServiceProvider noticiasWebServiceProvider;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getSupportActionBar().setTitle("Noticias");

        this.noticiasWebServiceProvider = new NoticiasWebServiceProvider(this.getApplicationContext());
        try {

            this.noticias = this.noticiasWebServiceProvider.execute().get();

            if(this.noticias.length == 0){

                setContentView(R.layout.nao_encontrado);

            }else{

                setContentView(R.layout.activity_noticias);

                this.recyclerView = (RecyclerView)findViewById(R.id.noticiasRecyclerView);
                this.layoutManager = new LinearLayoutManager(this);
                this.adapter = new NoticiasAdapter(this.noticias);
                this.recyclerView.setLayoutManager(this.layoutManager);
                this.recyclerView.setAdapter(this.adapter);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }




    }



    public void verNoticia(){

        // abrir webview para acessar link da notícia.

    }

}
