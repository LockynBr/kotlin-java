package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sortear(view: View) {
       val textoResultado = findViewById<TextView>(R.id.text_resultado) // O R é para identificar o projeto que está sendo utilizado.
        val numero = Random().nextInt(11) // 0...10 // Função randind
        textoResultado.setText("Número Gerado: $numero") // o $ é usado para fazer a formatação de uma variável em uma string.
    }

}