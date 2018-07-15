package com.example.luca.prae_app;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.luca.prae_app.NoticiaWebViewActivity;

public class ItemClickListener implements View.OnClickListener {

    private Context context;
    private TextView url;

    public ItemClickListener(Context context){

        this.context= context;

    }


    @Override
    public void onClick(View view) {

        this.url = (TextView)view.findViewById(R.id.url);

        Intent intent = new Intent(this.context,NoticiaWebViewActivity.class);

        intent.putExtra("url",this.url.getText());

        this.context.startActivity(intent);

    }
}
