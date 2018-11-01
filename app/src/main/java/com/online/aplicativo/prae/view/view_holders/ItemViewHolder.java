package com.online.aplicativo.prae.view.view_holders;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.online.aplicativo.prae.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView item;
    public TextView descricaoItem;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        this.setDescricaoItem((TextView) itemView.findViewById(R.id.descricaoItem));
        this.setItem((TextView) itemView.findViewById(R.id.item));
    }

    public TextView getItem() {
        return item;
    }

    public void setItem(TextView item) {
        this.item = item;
    }

    public TextView getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(TextView descricaoItem) {
        this.descricaoItem = descricaoItem;
    }
}
