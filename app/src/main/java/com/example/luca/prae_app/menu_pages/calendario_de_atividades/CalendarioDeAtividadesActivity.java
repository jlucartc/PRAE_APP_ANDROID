package com.example.luca.prae_app.menu_pages.calendario_de_atividades;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Compromisso;
import com.example.luca.prae_app.providers.CompromissosWebServiceProvider;
import com.example.luca.prae_app.view.adapters.CompromissosAdapter;

import java.util.concurrent.ExecutionException;

public class CalendarioDeAtividadesActivity extends AppCompatActivity {

    private RecyclerView calendarioRecyclerView;
    private Compromisso[] compromissos;
    private CompromissosWebServiceProvider compromissosWebServiceProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Calendário de atividades");

        this.compromissosWebServiceProvider = new CompromissosWebServiceProvider(this);

        try {

            this.compromissos = this.compromissosWebServiceProvider.execute().get();

            Log.i("COMPROMISSOS",String.valueOf(this.compromissos == null));

            if(this.compromissos == null || this.compromissos.length == 0){

                setContentView(R.layout.nao_encontrado);

                TextView aviso =  findViewById(R.id.aviso);

                aviso.setText("Não há atividades no momento");

            }else{

                setContentView(R.layout.activity_calendario_de_atividades);

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
