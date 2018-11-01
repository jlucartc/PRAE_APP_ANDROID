package com.online.aplicativo.prae.menu_pages.mapa_da_prae;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.online.aplicativo.prae.R;
import com.online.aplicativo.prae.models.Mapa;
import com.online.aplicativo.prae.providers.MapasWebServiceProvider;
import com.online.aplicativo.prae.view.adapters.MapasAdapter;

import java.util.concurrent.ExecutionException;

public class MapaDaPraeActivity extends AppCompatActivity {

    private Mapa[] mapas;
    private MapasWebServiceProvider mapasWebServiceProvider;
    private RecyclerView mapasRecyclerView;
    private MapasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getSupportActionBar().setTitle("Mapas da PRAE");

        this.mapasWebServiceProvider = new MapasWebServiceProvider(this.getApplicationContext());

        try {

            this.mapas = this.mapasWebServiceProvider.execute().get();

            if(this.mapas == null || this.mapas.length == 0){

                setContentView(R.layout.nao_encontrado);

                TextView aviso = findViewById(R.id.aviso);

                aviso.setText("Não há mapas cadastrados no momento");

            }else{

                setContentView(R.layout.activity_mapas_da_prae);

                this.mapasRecyclerView = findViewById(R.id.mapasRecyclerView);

                this.mapasRecyclerView.setLayoutManager(new LinearLayoutManager(this));

                this.adapter = new MapasAdapter(this.mapas);

                this.mapasRecyclerView.setAdapter(this.adapter);

            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
