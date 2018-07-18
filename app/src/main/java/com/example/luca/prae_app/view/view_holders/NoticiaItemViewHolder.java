package com.example.luca.prae_app.view.view_holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.luca.prae_app.R;

public class NoticiaItemViewHolder extends RecyclerView.ViewHolder{

    public TextView textView;
    public TextView statusNoticia;
    public TextView url;
    public TextView id;

    public NoticiaItemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.textView = (TextView)itemView.findViewById(R.id.mensagemNoticia);
        this.statusNoticia = (TextView)itemView.findViewById(R.id.statusNoticia);
        this.url = (TextView)itemView.findViewById(R.id.url);
        this.id = (TextView)itemView.findViewById(R.id.id);
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public TextView getStatusNoticia() {
        return statusNoticia;
    }

    public void setStatusNoticia(TextView statusNoticia) {
        this.statusNoticia = statusNoticia;
    }

    public TextView getUrl() {
        return url;
    }

    public void setUrl(TextView url) {
        this.url = url;
    }

    public TextView getId() {
        return id;
    }

    public void setId(TextView id) {
        this.id = id;
    }
}