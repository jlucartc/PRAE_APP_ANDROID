package com.example.luca.prae_app.view.adapters;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Noticia;
import com.example.luca.prae_app.view.listeners.NoticiaItemClickListener;
import com.example.luca.prae_app.view.view_holders.NoticiaItemViewHolder;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiaItemViewHolder> {

    private Noticia[] noticias;

    public NoticiasAdapter(Noticia[] noticias){

        this.noticias = noticias;

    }


    @NonNull
    @Override
    public NoticiaItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.noticia_item_view,viewGroup,false);

        view.setOnClickListener(new NoticiaItemClickListener(viewGroup.getContext()));

        NoticiaItemViewHolder vh = new NoticiaItemViewHolder(view);

        return vh;

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull NoticiaItemViewHolder viewHolder, int i) {

        viewHolder.textView.setText(this.noticias[i].getTitulo());
        viewHolder.url.setText(this.noticias[i].getGuid());
        if(!this.noticias[i].isNova()){

            viewHolder.getStatusNoticia().setVisibility(View.VISIBLE);
            viewHolder.getStatusNoticia().setBackground(null);
            //avisosViewHolder.getStatusNoticia().setBackgroundColor(Color.parseColor("#eeeeee"));
            viewHolder.getStatusNoticia().setText("Notícia lida");
            viewHolder.getStatusNoticia().setTextColor(Color.parseColor("#999999"));

        }else{

            viewHolder.statusNoticia.setVisibility(TextView.VISIBLE);

        }
        viewHolder.id.setText(String.valueOf(this.noticias[i].getId()));

    }

    @Override
    public int getItemCount() {

        return this.noticias.length;

    }
}
