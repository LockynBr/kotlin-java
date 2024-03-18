package com.example.aulapedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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

    public void selecionarPedra(View view) { //Método se o usuário escolher Pedra
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view) { //Método se o usuário escolher Papel
        verificarGanhador("papel");
    }

    public void selecionarTesoura(View view) { //Método se o usuário escolher Tesoura
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoriaApp() { //Método da escolha da máquina

        String[] opcoes = {"pedra", "papel", "tesoura"};//Opções em uma lista
        int numeroAleatorio = new Random().nextInt(3);//Gera um número aleatório

        ImageView imagemApp = findViewById(R.id.image_app); //Acessando o id da imagem
        String escolhaApp = opcoes[numeroAleatorio]; //Escolha da lista em palavra
        switch(escolhaApp) {
            case "pedra" :
                imagemApp.setImageResource(R.drawable.pedra); //Muda a imagem de acordo com o que foi esolhido pela máquina
                break;
            case "papel" :
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp; //O método retorna a escolha da máquina
    }

    private void verificarGanhador(String escolhaUsuario) { //Método para verificar o ganhador

        String escolhaApp = gerarEscolhaAleatoriaApp(); //Pega a esolha do app
        TextView textoResultado = findViewById(R.id.text_resultado); //Pega o texto do resultado

        //Consições de vitorias, derrotas e empates
        if(
           (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
           (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
           (escolhaApp == "tesoura" && escolhaUsuario == "papel"))
        {//App é o ganhador
            textoResultado.setText("Você perdeu :(");
        } else if (
            (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
            (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
            (escolhaUsuario == "tesoura" && escolhaApp == "papel"))
        {//Usuário é o ganhador
            textoResultado.setText("Você ganhou!! :)");
        } else {//Empate
            textoResultado.setText("Empate ;)");
        }

    }

}