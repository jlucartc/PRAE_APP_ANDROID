package com.example.luca.prae_app.menu_pages.notificacoes_por_email;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luca.prae_app.R;

public class NotificacoesPorEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacoes_por_email);

        getSupportActionBar().setTitle("Notificações por email");
    }
}
