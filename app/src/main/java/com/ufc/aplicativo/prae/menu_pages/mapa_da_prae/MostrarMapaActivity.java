package com.ufc.aplicativo.prae.menu_pages.mapa_da_prae;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.view.listeners.MapaDownloadClickListener;
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

        //this.getSupportActionBar().setTitle(getIntent().getStringExtra("nome"));
        //this.getSupportActionBar().hide();

        //BitmapDrawable bg = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.yellow_button));

        //bg.setTileModeX(android.graphics.Shader.TileMode.REPEAT);

        //this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffcc")));

        this.rota = getIntent().getStringExtra("rota");

        this.mapaId = getIntent().getIntExtra("mapaId",0);

        this.mapaImageView = findViewById(R.id.mapaImageView);

        this.mapaDownload = findViewById(R.id.baixarImagemButton);

        mapaDownload.setOnClickListener(new MapaDownloadClickListener(this.getApplicationContext(),this.mapaId));


        //this.mapaImageView.crea

        Picasso.with(this.getApplicationContext()).load(this.rota).fit().into(this.mapaImageView);


    }

}
