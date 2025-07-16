package com.projeto.geraranime;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //criação do array que vai armazenar as imagens
    int[] imagens = {
            R.drawable.afrosamurai,
            R.drawable.chainsawman,
            R.drawable.colorful,
            R.drawable.kaijuu,
            R.drawable.steinsgate
    };

    //converte o array de imagens em uma lista para poder fazer o embaralho
    //ArrayList é dinamico e pode adicionar ou remover elementos.
    List<Integer> imagemList = new ArrayList<>();
    //fazendo a inicialização em 0
    int indiceAtual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //converte o array de imagens para uma imagemlist
        //img é a variável que representará cada elemento do array
        // imagens à medida que o loop itera
        for (int img: imagens){
            imagemList.add(img);
            //a cada iteração esta pegando uma imagem atual do array imagens
            //e adicionando ao ArrayList imagemList
        }

        //embaralha a lista utilizando a classe collections que fornece metodos
        //estáticos para operar em coleções (listas)
        Collections.shuffle(imagemList);

        //busca o componenete imageview da activity_main com o respectivo
        // id associado a variavel para fazer a interação com os componentes
        ImageView botao_activity_main = findViewById(R.id.botao_activity_main);
        ImageView imageView = findViewById(R.id.imageView); //armazena as imagens anime

        //acessa o botao ImageView e seta para clicar e ai o codigo dentro sera executado
        botao_activity_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerarAnimes(imageView); //chamando o método e passa a imageView como arg
            }
        });
    }
    public void gerarAnimes(ImageView imageView){
        //obtem a imagem no indice atual da lista na posição do indice
        //atual. setImageResoure altera a imagem exibida na ImageView.
        if (indiceAtual < imagemList.size()) {
            imageView.setImageResource(imagemList.get(indiceAtual));
            indiceAtual++; //incrementa em 1, exibindo a proxima imagem da lista
        } else {
            // reinicia o índice atual se desejar exibir novamente
            indiceAtual = 0;
            Collections.shuffle(imagemList); // embaralha novamente
        }
    }
}
