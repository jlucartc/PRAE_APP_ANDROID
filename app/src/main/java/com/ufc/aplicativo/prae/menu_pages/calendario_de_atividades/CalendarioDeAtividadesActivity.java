package com.ufc.aplicativo.prae.menu_pages.calendario_de_atividades;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;
import com.ufc.aplicativo.prae.models.Compromisso;
import com.ufc.aplicativo.prae.providers.AtividadesWebServiceProvider;
import com.ufc.aplicativo.prae.view.adapters.CompromissosAdapter;

import java.util.concurrent.ExecutionException;

public class CalendarioDeAtividadesActivity extends AppCompatActivity {

    private RecyclerView calendarioRecyclerView;
    private Compromisso[] compromissos;
    private AtividadesWebServiceProvider compromissosWebServiceProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getSupportActionBar().setTitle("Calendário de atividades");

        this.compromissosWebServiceProvider = new AtividadesWebServiceProvider(this);

        try {

            this.compromissos = this.compromissosWebServiceProvider.execute().get();

            if(this.compromissos == null || this.compromissos.length == 0){

                setContentView(R.layout.nao_encontrado);

                TextView aviso =  findViewById(R.id.aviso);

                aviso.setText("Não há atividades no momento");

            }else{

                setContentView(R.layout.activity_atividades);

                this.calendarioRecyclerView = (RecyclerView)findViewById(R.id.calendarioRecyclerView);

                LinearLayoutManager layoutManager = new LinearLayoutManager(this);

                //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                this.calendarioRecyclerView.setHasFixedSize(true);

                this.calendarioRecyclerView.setLayoutManager(layoutManager);

                this.calendarioRecyclerView.setAdapter(new CompromissosAdapter(this.compromissos));

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }

}
