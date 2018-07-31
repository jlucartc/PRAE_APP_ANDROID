package com.example.luca.prae_app.menu_pages.notificacoes_por_email;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.view.listeners.EnviarEmailListener;

public class NotificacoesPorEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacoes_por_email);

        getSupportActionBar().setTitle("Notificações por email");

        Button enviarEmail = findViewById(R.id.enviarEmail);
        enviarEmail.setOnClickListener(new EnviarEmailListener());

    }
}
