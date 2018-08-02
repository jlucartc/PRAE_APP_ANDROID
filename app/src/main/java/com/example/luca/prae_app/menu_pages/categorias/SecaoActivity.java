package com.example.luca.prae_app.menu_pages.categorias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Paragrafo;
import com.example.luca.prae_app.providers.ParagrafosWebServiceProvider;
import com.example.luca.prae_app.providers.SecoesWebServiceProvider;
import com.example.luca.prae_app.view.adapters.SecaoAdapter;

import java.util.concurrent.ExecutionException;


public class SecaoActivity extends AppCompatActivity {

    private SecaoAdapter secaoAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView secaoRecyclerView;
    private Paragrafo[] paragrafos;
    private ParagrafosWebServiceProvider paragrafosWebServiceProvider;
    private int secaoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(getIntent().getStringExtra("secaoNome"));

        this.secaoId = getIntent().getIntExtra("secaoId",0);

        this.paragrafosWebServiceProvider = new ParagrafosWebServiceProvider(this.getApplicationContext(),this.secaoId);

        try {

            this.paragrafos = this.paragrafosWebServiceProvider.execute().get();

            if(this.paragrafos != null && this.paragrafos.length > 0){

                setContentView(R.layout.activity_secao);

                this.secaoAdapter = new SecaoAdapter(this.paragrafos);
                this.secaoRecyclerView = findViewById(R.id.secaoRecyclerView);
                this.secaoRecyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
                this.secaoRecyclerView.setAdapter(this.secaoAdapter);

            }else{

                setContentView(R.layout.nao_encontrado);

                TextView aviso = findViewById(R.id.aviso);

                aviso.setText("Sem acesso às informações");

            }



        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }




    }
}
