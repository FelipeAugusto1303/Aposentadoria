package com.example.aposentadoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spnSexo = findViewById<Spinner>(R.id.spnSexo)
        val idade = findViewById<EditText>(R.id.edtIdade)
        val btnCalcula = findViewById<Button>(R.id.btnCalcula)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        //adicionando itens ao spinner
        spnSexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listOf("masculino", "feminino"))

        btnCalcula.setOnClickListener{
            //funcao que vai calcular a aposentadoria

            val sexo = spnSexo.selectedItem as String
            val idade = idade.text.toString().toInt()

            var resultado = 0

            when (sexo){
                "masculino" -> {
                    resultado = 65 - idade
                }
                "feminino" -> {
                    resultado = 60 - idade
                }
                else -> {
                    println("Nenhum sexo selecionado")
                }
            }

            txtResultado.text = "Faltam $resultado anos para voce se aposentar"
        }
    }
}