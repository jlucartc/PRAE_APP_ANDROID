package com.example.luca.prae_app.menu_pages.mapa_da_prae;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Mapa;
import com.example.luca.prae_app.providers.MapasWebServiceProvider;
import com.example.luca.prae_app.view.listeners.MapaDownloadClickListener;
import com.squareup.picasso.Picasso;

public class MostrarMapaActivity extends AppCompatActivity {

    private String rota;
    private int mapaId;
    private ImageView mapaImageView;
    private Button mapaDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_mapa);

        this.rota = getIntent().getStringExtra("rota");

        this.mapaId = getIntent().getIntExtra("mapaId",0);

        this.mapaImageView = findViewById(R.id.mapaImageView);

        this.mapaDownload = findViewById(R.id.baixarImagemButton);

        mapaDownload.setOnClickListener(new MapaDownloadClickListener(this.getApplicationContext(),this.mapaId));


        //this.mapaImageView.crea

        Picasso.with(this.getApplicationContext()).load(this.rota).fit().into(this.mapaImageView);


    }

}
