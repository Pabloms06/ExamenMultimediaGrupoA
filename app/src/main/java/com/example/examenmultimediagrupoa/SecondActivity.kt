package com.example.examenmultimediagrupoa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity()  {

    companion object {
        const val PARAM1 = "Hola"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val editText = findViewById<EditText>(R.id.editTextSecondActivity)
        val textView = findViewById<TextView>(R.id.textViewSecondActivity)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)


        val texto = intent.getStringExtra(PARAM1)

        texto?.let {
            textView.text = it.replace(" ", "\n")
        }

        button1.setOnClickListener {
            texto?.let {
                textView.text = darTamano(it)
            }
        }

        button2.setOnClickListener {
            texto?.let {
                textView.text = ordenarPorTamano(it)
            }
        }

        button3.setOnClickListener {
            texto?.let {
                textView.text = filtrarPorTamano(it, editText.text.toString().toInt())
            }
        }
    }

    private fun filtrarPorTamano(texto: String, valorFiltrado : Int) : String{
        val lista = texto.split(" ")
        val listaFiltrada = lista.filter {
            it.length >= valorFiltrado
        }

        var salida = ""
        listaFiltrada.forEach {
            salida += it + "\n"
        }
        return salida
    }

    private fun ordenarPorTamano(texto: String) : String{
        val lista = texto.split(" ")
        val listaOrdenada = lista.sortedByDescending {
            it.length
        }
        var salida = ""
        listaOrdenada.forEach {
            salida += it + "\n"
        }

        return salida
    }

    private fun darTamano(texto : String) : String {
        val lista = texto.split(" ")
        var salida = ""
        lista.forEach {
            salida += it + " " + it.length + "\n"
        }
        return salida
    }


}