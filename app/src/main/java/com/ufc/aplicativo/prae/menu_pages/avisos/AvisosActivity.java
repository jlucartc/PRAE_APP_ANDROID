package com.ufc.aplicativo.prae.menu_pages.avisos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.models.Aviso;
import com.ufc.aplicativo.prae.providers.AvisosWebServiceProvider;
import com.ufc.aplicativo.prae.view.adapters.AvisosAdapter;

import java.util.concurrent.ExecutionException;

public class AvisosActivity extends AppCompatActivity {

    private AvisosWebServiceProvider avisosWebServiceProvider;
    private Aviso[] avisos;
    private RecyclerView avisosRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter avisosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos);

        //getSupportActionBar().setTitle("Avisos");

        this.avisosWebServiceProvider = new AvisosWebServiceProvider(this.getApplicationContext());

        try {

            this.avisos = this.avisosWebServiceProvider.execute().get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(this.avisos.length <= 0){

            setContentView(R.layout.nao_encontrado);

            TextView aviso = findViewById(R.id.aviso);

            aviso.setText("Não há avisos no momento");

        }else{

            this.avisosRecyclerView = findViewById(R.id.avisosRecyclerView);

            this.layoutManager = new LinearLayoutManager(this.getApplicationContext());

            this.avisosAdapter = new AvisosAdapter(this.avisos,this.getApplicationContext());

            this.avisosRecyclerView.setLayoutManager(this.layoutManager);

            this.avisosRecyclerView.setAdapter(this.avisosAdapter);

        }

    }

    /*public void checarAvisos(View v){

        if(this.avisosWebServiceProvider.getStatus() != AsyncTask.Status.RUNNING){
            this.avisosWebServiceProvider.execute();
        }

    }*/

}


