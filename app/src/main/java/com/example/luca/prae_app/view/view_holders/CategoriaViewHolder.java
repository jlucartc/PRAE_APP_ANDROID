package com.example.luca.prae_app.view.view_holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.luca.prae_app.R;

public class CategoriaViewHolder extends RecyclerView.ViewHolder {

    private Button botaoCategoria;

    public CategoriaViewHolder(@NonNull View itemView) {
        super(itemView);

        this.botaoCategoria = (Button)itemView.findViewById(R.id.botaoBolsa);

    }

    public Button getBotaoBolsa() {
        return botaoCategoria;
    }

    public void setBotaoBolsa(Button botaoBolsa) {
        this.botaoCategoria = botaoBolsa;
    }
}
