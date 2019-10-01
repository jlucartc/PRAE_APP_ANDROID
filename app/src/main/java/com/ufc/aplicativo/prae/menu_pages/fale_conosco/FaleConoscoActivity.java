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
        //TextView titulo = findViewById(R.id.nome);
        //TextView faleConosco = findViewById(R.id.texto);

        TextView faleConosco = findViewById(R.id.faleConosco);

        //titulo.setText("Fale Conosco!");
        faleConosco.setText(Html.fromHtml("Contatos:<br/>" +
                "Fone:  <b>(85) 3366-7440/3366-7444</b><br/>" +
                "E-mail: <b>infopraeufc@gmail.com</b><br/>" +
                "<br/>" +
                "Nos acompanhe nas redes sociais:<br/>" +
                "Facebook: <b> fb.com/ufcprae </b> <br/>" +
                "Instagram: <b> @praeufc </b> <br/>" +
                "Canal no youtube: <b> PRAE - UFC </b> <br/>" +
                "<br/>" +
                "Horário de funcionamento:<br/>"+
                "<b> Segunda - Quinta: </b> <br/>" +
                "<b> &#9679; 08:00 ás 12:00 </b>-<b> 13:00 ás 17:00 </b> <br/>" +"<br/>" +
                "Na sexta o expediente é interno! </br>" + "<br/>" +
                "Te esperamos aqui! :)<br/>"));

    }

}
