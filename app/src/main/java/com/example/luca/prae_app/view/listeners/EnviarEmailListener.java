package com.example.luca.prae_app.view.listeners;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.menu_pages.notificacoes_por_email.CadastrarEmailService;

import java.util.concurrent.ExecutionException;

public class EnviarEmailListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {

        EditText emailEdit = ((ViewGroup)view.getParent()).findViewById(R.id.email);

        String email = emailEdit.getText().toString();

        emailEdit.setText("");

        CadastrarEmailService service = new CadastrarEmailService(view.getContext(),email);

        try {

            Boolean cadastro = service.execute().get();

            if(!cadastro){

                Toast toast = Toast.makeText(view.getContext()
                        ,"Erro no cadastro do email. Tente novamente dentro de alguns segundos",Toast.LENGTH_SHORT);

                toast.show();

            }else{

                Toast toast = Toast.makeText(view.getContext()
                        ,"Email cadastrado com sucesso!",Toast.LENGTH_SHORT);

                toast.show();

            }

        } catch (InterruptedException e) {
            e.printStackTrace();

            Toast toast = Toast.makeText(view.getContext()
                    ,"Erro no cadastro do email. Tente novamente dentro de alguns segundos",Toast.LENGTH_SHORT);

            toast.show();

        } catch (ExecutionException e) {
            e.printStackTrace();

            Toast toast = Toast.makeText(view.getContext()
                    ,"Erro no cadastro do email. Tente novamente dentro de alguns segundos",Toast.LENGTH_SHORT);

            toast.show();

        }

        //Toast toast = Toast.makeText(view.getContext(),"Email enviado",Toast.LENGTH_SHORT);

        //toast.show();


    }
}
