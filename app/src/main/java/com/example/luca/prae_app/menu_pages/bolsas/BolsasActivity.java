package com.example.luca.prae_app.menu_pages.bolsas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Categoria;
import com.example.luca.prae_app.providers.BolsasWebServiceProvider;
import com.example.luca.prae_app.view.adapters.BolsasAdapter;

import java.util.concurrent.ExecutionException;

public class BolsasActivity extends AppCompatActivity {

    private RecyclerView bolsasRecyclerView;
    private RecyclerView.LayoutManager layoutManager ;
    private BolsasAdapter bolsasAdapter;
    private BolsasWebServiceProvider bolsasWebServiceProvider;
    private Categoria[] bolsas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolsas);

        getSupportActionBar().setTitle("Bolsas");

        this.bolsasWebServiceProvider = new BolsasWebServiceProvider(this.getApplicationContext());

        try {
            this.bolsas = (Categoria[])this.bolsasWebServiceProvider.execute().get();

            if(this.bolsas != null && this.bolsas.length > 0){


                this.setContentView(R.layout.activity_bolsas);

                this.bolsasRecyclerView = findViewById(R.id.bolsasRecyclerView);

                this.layoutManager = new LinearLayoutManager(this.getApplicationContext());

                this.bolsasAdapter = new BolsasAdapter(this.bolsas);

                this.bolsasRecyclerView.setLayoutManager(this.layoutManager);

                this.bolsasRecyclerView.setAdapter(this.bolsasAdapter);


            }else{

                this.setContentView(R.layout.nao_encontrado);

                TextView aviso = findViewById(R.id.aviso);

                aviso.setText("Sem bolsas no momento");

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
