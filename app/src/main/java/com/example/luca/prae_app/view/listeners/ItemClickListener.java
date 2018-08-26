package com.example.luca.prae_app.view.listeners;

import android.content.ClipData;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luca.prae_app.R;

public class ItemClickListener implements View.OnClickListener {

    private Boolean hasDescricao;
    private Boolean aberto;
    private Context context;
    private View parent;


    public ItemClickListener(Boolean hasDescricao, Context context, View parent){

        this.setHasDescricao(hasDescricao);
        this.aberto = false;
        this.parent = parent;

    }

    @Override
    public void onClick(View view) {

        Log.i("ItemClickListener","getHasDescricao(): "+String.valueOf(this.getHasDescricao()));

        if(this.getHasDescricao()){
            if(this.getAberto() == false){

                this.setAberto(true);
                TextView item = view.findViewById(R.id.item);
                TextView descricao = view.findViewById(R.id.descricaoItem);
                descricao.setVisibility(View.VISIBLE);
                Drawable drawable = this.getContext().getResources().getDrawable(android.R.drawable.arrow_up_float);
                drawable.setColorFilter(this.getContext().getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_ATOP);
                drawable.setBounds(0, 0, 50, 50);
                item.setCompoundDrawables(drawable, null, null, null);


            }else{

                this.setAberto(false);
                TextView item = view.findViewById(R.id.item);
                TextView descricao = view.findViewById(R.id.descricaoItem);
                descricao.setVisibility(View.GONE);
                Drawable drawable = this.getContext().getResources().getDrawable(android.R.drawable.arrow_down_float);
                drawable.setColorFilter(this.getContext().getResources().getColor(android.R.color.holo_blue_dark), PorterDuff.Mode.SRC_ATOP);
                drawable.setBounds(0, 0, 50, 50);
                item.setCompoundDrawables(drawable, null, null, null);

            }

            if(this.parent.getParent() instanceof View){

                ((View) this.parent.getParent()).invalidate();

            }

            Log.i("ItemCLickListener","adapter notificado");

        }

    }

    public Boolean getHasDescricao() {
        return hasDescricao;
    }

    public void setHasDescricao(Boolean hasDescricao) {
        this.hasDescricao = hasDescricao;
    }

    public Boolean getAberto() {
        return aberto;
    }

    public void setAberto(Boolean aberto) {
        this.aberto = aberto;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
