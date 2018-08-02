package com.example.luca.prae_app.menu_pages.notificacoes_por_email;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.luca.prae_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CadastrarEmailService extends AsyncTask<Void,Void,Boolean> {

    private String cadastrarEmailUrl;
    private String email;
    private Context context;

    public CadastrarEmailService(Context context, String email){

        this.context = context;

        this.email = email;

        this.cadastrarEmailUrl = this.context.getString(R.string.localhost)+"/app/ws/cadastrarEmail";

    }

    @Override
    protected Boolean doInBackground(Void... strings) {
        return this.cadastrarEmail(this.email);
    }

    public Boolean cadastrarEmail(String email){

        try {

            URL url = new URL(this.cadastrarEmailUrl+"/"+email);

            HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();

            httpCon.setRequestMethod("GET");

            InputStream inputStream = httpCon.getInputStream();

            //InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            //BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //String response = bufferedReader.readLine();




            httpCon.disconnect();

            //inputStreamReader.close();

            inputStream.close();

            //bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }

        return true;

    }


}
