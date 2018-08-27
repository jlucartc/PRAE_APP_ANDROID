package com.example.luca.prae_app.view.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Item;
import com.example.luca.prae_app.models.Lista;
import com.example.luca.prae_app.models.Paragrafo;
import com.example.luca.prae_app.view.listeners.ItemClickListener;
import com.example.luca.prae_app.view.view_holders.ItemViewHolder;
import com.example.luca.prae_app.view.view_holders.ListaViewHolder;
import com.example.luca.prae_app.view.view_holders.ParagrafoViewHolder;

public class SecaoAdapter extends RecyclerView.Adapter<ParagrafoViewHolder> {

    private Paragrafo[] paragrafos;
    private Context context;
    private ViewGroup viewGroup;

    public SecaoAdapter(Paragrafo[] paragrafos){

        this.setParagrafos(paragrafos);

    }

    @NonNull
    @Override
    public ParagrafoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        this.setContext(viewGroup.getContext());

        this.setViewGroup(viewGroup);

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.paragrafo_layout,viewGroup,false);

        ParagrafoViewHolder vh = new ParagrafoViewHolder(v);

        vh.setTitulo((TextView) v.findViewById(R.id.titulo));
        vh.setTexto((TextView) v.findViewById(R.id.texto));

        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ParagrafoViewHolder paragrafoViewHolder, int i) {

        paragrafoViewHolder.getTexto().setText(this.getParagrafos()[i].getTexto());
        paragrafoViewHolder.getTitulo().setText(this.getParagrafos()[i].getTitulo());

        LinearLayout l = paragrafoViewHolder.getListaListas();

        Lista[] listas = this.getParagrafos()[i].getListas();

        for(Lista item : listas){

            View v = LayoutInflater.from(this.getContext()).inflate(R.layout.lista_layout,this.getViewGroup(),false);

            if(v.getParent() != null) {
                ((ViewGroup) v.getParent()).removeView(v);
            }

            ListaViewHolder vh = new ListaViewHolder(v);

            vh.getTituloLista().setText(item.getNome());
            LinearLayout li = vh.getListaItens();

            Item[] itens = item.getItens();

            for(Item itemItens : itens){

                View iv = LayoutInflater.from(this.getContext()).inflate(R.layout.lista_item_layout,this.getViewGroup(),false);

                if(iv.getParent() != null){
                    ((ViewGroup)iv.getParent()).removeView(iv);
                }

                TextView tv = iv.findViewById(R.id.item);
                TextView tvD = iv.findViewById(R.id.descricaoItem);

                Log.i("SecaoAdapter","tvD: --"+tvD.getText().toString().trim()+"--");

                iv.setOnClickListener(new ItemClickListener(!(itemItens.getDescricao() == null || itemItens.getDescricao().isEmpty()),this.getContext(),li));

                ItemViewHolder ivh = new ItemViewHolder(iv);

                ivh.getItem().setText(itemItens.getNome());
                ivh.getDescricaoItem().setVisibility(View.GONE);
                ivh.getDescricaoItem().setText(itemItens.getDescricao());

                Drawable drawable = this.getContext().getResources().getDrawable(android.R.drawable.arrow_down_float);
                if(itemItens.getDescricao() != null && !itemItens.getDescricao().isEmpty()){

                    drawable.setColorFilter(this.getContext().getResources().getColor(android.R.color.holo_blue_dark), PorterDuff.Mode.SRC_ATOP);

                }else{

                    drawable.setColorFilter(this.getContext().getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_ATOP);

                }
                drawable.setBounds(0, 0, 30, 30);
                ivh.getItem().setCompoundDrawables(drawable, null, null, null);
                li.addView(iv);

            }

            l.addView(v);

        }

    }

    @Override
    public int getItemCount() {
        return this.getParagrafos().length;
    }

    public Paragrafo[] getParagrafos() {
        return paragrafos;
    }

    public void setParagrafos(Paragrafo[] paragrafos) {
        this.paragrafos = paragrafos;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ViewGroup getViewGroup() {
        return viewGroup;
    }

    public void setViewGroup(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
    }
}
