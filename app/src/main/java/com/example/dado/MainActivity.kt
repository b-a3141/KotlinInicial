package com.example.dado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val launchButton: Button = findViewById(R.id.button)
        launchButton.setOnClickListener{
            //Para 2 dados usar:
            lanzarDosDados()

            //Para un solo dado usar:
            // lanzarDado()
        }

        //Para un solo dado usar:
       // lanzarDado()
        lanzarDosDados()

    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun lanzarDado() {
        // Create new Dice object with 6 sides and roll the dice
        val dado = Dado(6)
        val resultadoDelLanzamiento = dado.launch()
        val imagenDado: ImageView = findViewById(R.id.imageView)
        imagenDado.contentDescription = resultadoDelLanzamiento.toString()

        // Determine which drawable resource ID to use based on the dice roll
        val recursoImagen = when (resultadoDelLanzamiento){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.ic_launcher_foreground
            else -> R.drawable.dice_6
        }
        imagenDado.setImageResource(recursoImagen)
    }

    private fun lanzarDosDados() {
        // Create new Dice object with 6 sides and roll the dice
        val dado1 = Dado(6)
        val dado2 = Dado(6)
        val resultadoDelLanzamiento1 = dado1.launch()
        val resultadoDelLanzamiento2 = dado2.launch()
        val imagenDado1: ImageView = findViewById(R.id.imageView)
        val imagenDado2: ImageView = findViewById(R.id.imageView2)
        imagenDado1.contentDescription = resultadoDelLanzamiento1.toString()
        imagenDado2.contentDescription = resultadoDelLanzamiento2.toString()
        // Determine which drawable resource ID to use based on the dice roll
        val recursoImagen1 = when (resultadoDelLanzamiento1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.ic_launcher_foreground
            else -> R.drawable.dice_6
        }
        val recursoImagen2 = when (resultadoDelLanzamiento2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.ic_launcher_foreground
            else -> R.drawable.dice_6
        }
        imagenDado1.setImageResource(recursoImagen1)
        imagenDado2.setImageResource(recursoImagen2)
    }
    class Dado(val numSides: Int)
    {
        fun launch(): Int {
            //método 1
           // return (1..numSides).random()

            //método 2
            val rango = 1..6
            val resultadoAzaroso = rango.random()
            return resultadoAzaroso
        }
    }
}