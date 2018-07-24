package com.example.luca.prae_app.view.view_holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.luca.prae_app.R;

public class BolsasViewHolder extends RecyclerView.ViewHolder {

    private Button botaoBolsa;

    public BolsasViewHolder(@NonNull View itemView) {
        super(itemView);

        this.botaoBolsa = (Button)itemView.findViewById(R.id.botaoBolsa);

    }

    public Button getBotaoBolsa() {
        return botaoBolsa;
    }

    public void setBotaoBolsa(Button botaoBolsa) {
        this.botaoBolsa = botaoBolsa;
    }
}
