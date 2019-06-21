package com.ufc.aplicativo.prae.menu_pages.fale_conosco;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.ufc.aplicativo.prae.R;

public class FaleConoscoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fale_conosco);

        //getSupportActionBar().hide();

        TextView faleConosco = findViewById(R.id.faleConosco);

        faleConosco.setText(Html.fromHtml("Deseja entrar em contato com a PRAE? O nosso endereço de email é <b><i>case@ufc.br</i></b>. O nosso telefone é <b><i>3366-7444</i></b>. Nosso horário de funcionamento é das <b><i>8 da manhã</i></b> até as <b><i>17 horas</i></b>. Te esperamos aqui! :)"));

    }

}
