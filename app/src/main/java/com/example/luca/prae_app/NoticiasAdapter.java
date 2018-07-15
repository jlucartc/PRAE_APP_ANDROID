package com.example.luca.prae_app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.ViewHolder> {

    private Noticia[] noticias;

    public NoticiasAdapter(Noticia[] noticias){

        this.noticias = noticias;

    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public TextView statusNoticia;
        public TextView url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = (TextView)itemView.findViewById(R.id.mensagemNoticia);
            this.statusNoticia = (TextView)itemView.findViewById(R.id.statusNoticia);
            this.url = (TextView)itemView.findViewById(R.id.url);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.noticia_item_view,viewGroup,false);

        view.setOnClickListener(new ItemClickListener(viewGroup.getContext()));

        ViewHolder vh = new ViewHolder(view);

        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.textView.setText(this.noticias[i].getTitulo());
        viewHolder.url.setText(this.noticias[i].getGuid());
        if(!this.noticias[i].isNova()){

            viewHolder.statusNoticia.setVisibility(TextView.INVISIBLE);

        }

    }

    @Override
    public int getItemCount() {

        return this.noticias.length;

    }
}