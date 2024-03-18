package com.example.aulafrasesdodia;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Atributo
    String[] frases = {
            "Acredite em si mesmo, pois é o primeiro passo para alcançar o impossível.",
            "Sucesso não é a chave para a felicidade. Felicidade é a chave para o sucesso. Se você ama o que faz, você será bem-sucedido.",
            "Não importa quantas vezes você cai, o que importa é quantas vezes você se levanta e continua tentando.",
            "O que você faz hoje pode melhorar todos os seus amanhãs.",
            "O maior prazer na vida é fazer o que as pessoas dizem que você não é capaz de fazer.",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void gerarFrase(View view) {

        TextView texto = findViewById(R.id.textResultado); //Pega o TextView e coloca em uma var
        int numeroAleatorio = new Random().nextInt( 5 ); // 0 1 2 / Cria uma var e instancia o random e pega um atributo do random.
        String frase = frases [numeroAleatorio]; //Cria uma var para pegar do foreach das frases e exprimir apenas a que saiu no bound do random.

        texto.setText(frase);

    }

    public void exibirTodas(View view) {

        TextView texto = findViewById(R.id.textResultado);

        String textoResultado = ""; // Cria uma var vazia.
        for (String frase : frases) { // Faz um foreach para exprimir cada frase, já que os atributos estão em uma lista.
            textoResultado = textoResultado + frase + "\n"; // Pega cada frase e concatena para exibir tudo.
        }
        texto.setText( textoResultado); // Manda o resultado para o textoResultado.
    }

}