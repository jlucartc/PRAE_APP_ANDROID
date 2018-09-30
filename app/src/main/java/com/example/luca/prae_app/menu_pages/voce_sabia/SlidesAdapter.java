package com.example.luca.prae_app.menu_pages.voce_sabia;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.view.listeners.LinkClickListener;

public class SlidesAdapter extends PagerAdapter {

    private String[] lista_titulos = {"Sobre a PRAE","Coordenadorias",
    "CASE","CAD","CRU","Quer saber mais?"};

    private String[] lista_conteudos = {
            "A PRAE - Pró-Reitoria de Assuntos Estudantis é a unidade que administra políticas para o progresso e apoio ao estudante de graduação da Universidade Federal do Ceará (UFC).\n\nSeu objetivo é incentivar, acompanhar e promover o desenvolvimento do estudante em toda sua trajetória acadêmica, através de ações efetivas nas áreas social, técnico-científica, cultural, política e esportiva.\n",
            "Vem cá, você sabia que a PRAE tem três coordenadorias?\n"+"Pois é, as coordenadorias têm o objetivo de juntas estimularem e auxiliarem os estudantes no geral. Tem um trabalho forte desde o planejamento a execução dos programas assistenciais dirigidos  comunidade estudantil.\n",
            "Descrição da CASE",
            "Descrição da CAD",
            "Descrição da CRU",
            "Deseja saber mais ainda sobre a PRAE? Acesse o site no link abaixo e fique por dentro de tudo o que a PRAE anda fazendo para você."
    };

    private int[] lista_imagens = {R.drawable.acolhimento,R.drawable.acolhimento,R.drawable.acolhimento,R.drawable.acolhimento,R.drawable.acolhimento,R.drawable.acolhimento};

    private Boolean[] lista_has_link = {false,false,false,false,false,true};

    private String[] lista_links_titulos = {null,null,null,null,null,"Ir para o site da PRAE"};

    private String[] lista_links = {null,null,null,null,null,"http://prae.ufc.br"};

    @Override
    public int getCount() {
        return this.lista_titulos.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.slides,container,false);

        TextView titulo = v.findViewById(R.id.titulo);
        TextView conteudo = v.findViewById(R.id.conteudo);
        ImageView imagem = v.findViewById(R.id.imagem);
        Button link = v.findViewById(R.id.link);
        LinearLayout dots = v.findViewById(R.id.dots);

        titulo.setText(this.lista_titulos[position]);
        conteudo.setText(this.lista_conteudos[position]);
        imagem.setImageDrawable(v.getResources().getDrawable(R.drawable.acolhimento));
        imagem.setMinimumWidth(150);
        imagem.setMinimumHeight(150);
        imagem.setMaxHeight(150);
        imagem.setMaxWidth(150);

        for(int i = 0; i < this.getCount(); i++){
            if(i == position){

                ImageView dot = new ImageView(container.getContext());
                dot.setImageDrawable(v.getResources().getDrawable(R.drawable.active_dot));
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(12,12);
                lp.setMargins(0,0,5,0);
                dot.setLayoutParams(lp);
                dots.addView(dot);

            }else{

                ImageView dot = new ImageView(container.getContext());
                dot.setImageDrawable(v.getResources().getDrawable(R.drawable.innactive_dot));
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(12,12);
                lp.setMargins(0,0,5,0);
                dot.setLayoutParams(lp);
                dots.addView(dot);

            }
        }

        if(this.lista_has_link[position]){

            link.setVisibility(View.VISIBLE);
            link.setText(this.lista_links_titulos[position]);
            link.setOnClickListener(new LinkClickListener(this.lista_links[position]));

        }

        container.addView(v);

        return v;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
