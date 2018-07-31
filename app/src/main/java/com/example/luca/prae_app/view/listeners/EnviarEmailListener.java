package com.example.luca.prae_app.view.listeners;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luca.prae_app.R;

public class EnviarEmailListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {

        EditText emailEdit = ((ViewGroup)view.getParent()).findViewById(R.id.email);

        String email = emailEdit.getText().toString();

        emailEdit.setText("");

        Toast toast = Toast.makeText(view.getContext(),"Email enviado",Toast.LENGTH_SHORT);

        toast.show();


    }
}
