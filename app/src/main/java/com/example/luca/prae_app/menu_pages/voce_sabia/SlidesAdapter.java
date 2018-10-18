package com.example.luca.prae_app.menu_pages.voce_sabia;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

    /*
    *   Inicialização das listas contendo os títulos, conteudos e as imagens dos slides.
    *
    *   Os títulos e conteúdos estão declarados em /res/values/strings. Para adicionar os textos de
    *   uma nova aba, ou modificar uma aba atual, basta declarar novas strings nesse documento
    *   e inserí-las nas listas correspondentes, seguindo o modelo abaixo ou, se for
    *   o caso, apenas altere as linhas já existentes.
    *
    *   As imagens estão declaradas em /res/drawables e devem seguir o mesmo procedimentos dos
    *   textos.
    *
    * */

    private Context context;
    private String[] listaTitulos;
    private String[] listaConteudos;
    private Integer[] listaImagens;

    public SlidesAdapter(Context context){

        this.context = context;

        this.listaTitulos = new String[]{
                this.context.getString(R.string.tituloAba1),
                this.context.getString(R.string.tituloAba2),
                this.context.getString(R.string.tituloAba6)
        };

        this.listaConteudos = new String[]{
                this.context.getString(R.string.conteudoAba1),
                this.context.getString(R.string.conteudoAba2),
                this.context.getString(R.string.conteudoAba6)
        };

        this.listaImagens = new Integer[]{
                R.drawable.sobre_a_prae,
                R.drawable.coordenadorias,
                R.drawable.saiba_mais
        };

    }



    /*
    *
    *  listaHasLink : determina se a aba de determinado índice possuirá algum link ou não
    *  listaLinkTitulos : lista com os títulos dos links
    *  listaLinks : lista com as strings com as urls dos links
    *
    *  Se uma determinada aba não possuir links, todas as listas deverão possuir valor 'null'
    *  nos índices correspondentes às abas.
    *
    * */

    private Boolean[] listaHasLink = {
            false,
            false,
            true
    };

    private String[] listaLinksTitulos = {
            null,
            null,
            "Ir para o site da PRAE"
    };

    private String[] listaLinks = {
            null,
            null,
            "http://prae.ufc.br"
    };

    /*
    *   Retorna o número correspondente à quantidade de abas
    *
    * */

    @Override
    public int getCount() {
        return this.listaTitulos.length;
    }

    /*
    *
    *  Checa se determinada view pertence ao objeto
    *
    * */

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (LinearLayout)o);
    }

    /*
    *
    *  Função responsável por instanciar a view do slide e setar as suas informações
    *
    * */

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.slides,container,false);

        TextView titulo = v.findViewById(R.id.titulo);
        TextView conteudo = v.findViewById(R.id.conteudo);
        ImageView imagem = v.findViewById(R.id.imagem);
        Button link = v.findViewById(R.id.link);
        LinearLayout dots = v.findViewById(R.id.dots);

        titulo.setText(this.listaTitulos[position]);
        conteudo.setText(this.listaConteudos[position]);


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

        if(this.listaHasLink[position]){

            link.setVisibility(View.VISIBLE);
            link.setText(this.listaLinksTitulos[position]);
            link.setOnClickListener(new LinkClickListener(this.listaLinks[position]));

        }

        if(this.listaImagens[position] != null){

            imagem.setImageDrawable(v.getResources().getDrawable(this.listaImagens[position]));
            imagem.setMinimumWidth(150);
            imagem.setMinimumHeight(150);
            imagem.setMaxHeight(150);
            imagem.setMaxWidth(150);

        }else{

            imagem.setVisibility(View.GONE);

        }

        container.addView(v);

        return v;

    }

    /*
    *
    * Função responsável por destruir os itens da view
    *
    * */

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
