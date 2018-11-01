package com.online.aplicativo.prae.view.view_holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.online.aplicativo.prae.R;

public class CompromissoItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView simboloCalendario;
    private TextView titulo;
    private TextView horario;
    private TextView local;
    private Context context;

    public CompromissoItemViewHolder(@NonNull View itemView) {

        super(itemView);

        this.context = context;

        this.simboloCalendario = (ImageView)itemView.findViewById(R.id.simboloCalendario);
        this.titulo = (TextView)itemView.findViewById(R.id.titulo);
        this.horario = (TextView)itemView.findViewById(R.id.horario);
        this.local = (TextView) itemView.findViewById(R.id.local);


    }

    public ImageView getSimboloCalendario() {
        return simboloCalendario;
    }

    public void setSimboloCalendario(ImageView simboloCalendario) {
        this.simboloCalendario = simboloCalendario;
    }

    public TextView getTitulo() {
        return titulo;
    }

    public void setTitulo(TextView titulo) {
        this.titulo = titulo;
    }

    public TextView getHorario() {
        return horario;
    }

    public void setHorario(TextView horario) {
        this.horario = horario;
    }

    public TextView getLocal() {
        return local;
    }

    public void setLocal(TextView local) {
        this.local = local;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
