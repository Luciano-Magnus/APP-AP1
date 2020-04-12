package com.magnus.cerveja

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {
    var tamanho1 = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.dropDown)
        btn_add.setOnClickListener(View.OnClickListener {
            if (!"".equals(edt_valor1.text.toString())) {
                var enviar = Valores1(edt_valor1.text.toString(), tamanho1.toString())
                val enviarPara = Intent(this, Cerveja2::class.java)
                enviarPara.putExtra("dados1", enviar)
                startActivity(enviarPara)
            } else {
                val alerta =
                    AlertDialog.Builder(this@MainActivity)
                alerta.setTitle("Aviso")
                alerta
                    .setIcon(R.drawable.ic_info_foreground)
                    .setMessage("Preencha todos os campos")
                    .setCancelable(true)
                    .setPositiveButton("OK",
                        DialogInterface.OnClickListener { dialogInterface, i -> })
                val alertDialog = alerta.create()
                alertDialog.show()
            }
        })
        var listaDeItens = arrayOf("1000 ml", "600 ml", "550 ml", "355 ml", "350 ml", "300 ml")
        spinner!!.setOnItemSelectedListener(this)
        val escolha = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaDeItens)
        escolha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(escolha)
    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, posicao: Int, id: Long) {
        if (posicao == 0) {
            tamamhos.text = "1000 ml"
            tamanho1 = 1000
        }
        if (posicao == 1) {
            tamamhos.text = "600 ml"
            tamanho1 = 600
        }
        if (posicao == 2) {
            tamamhos.text = "550 ml"
            tamanho1 = 550
        }
        if (posicao == 3) {
            tamamhos.text = "355 ml"
            tamanho1 = 355
        }
        if (posicao == 4) {
            tamamhos.text = "350 ml"
            tamanho1 = 350
        }
        if (posicao == 5) {
            tamamhos.text = "300 ml"
            tamanho1 = 300
        }

    }

    override fun onNothingSelected(arg0: AdapterView<*>) {
    }

    override fun onClick(v: View?) {
    }
}

