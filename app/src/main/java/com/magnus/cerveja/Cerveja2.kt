package com.magnus.cerveja

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.strictmode.CleartextNetworkViolation
import android.text.method.TextKeyListener.clear
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_cerveja2.*
import kotlinx.android.synthetic.main.activity_main.btn_add
import kotlinx.android.synthetic.main.activity_main.tamamhos

class Cerveja2 : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {
    var tamanho = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cerveja2)
        val spinner = findViewById<Spinner>(R.id.dropDown)
        var edt_valor = findViewById<EditText>(R.id.edt_valor2)
        btn_add.setOnClickListener(View.OnClickListener {
            //Ajustar telas(valores validar info)
            //corrigir bugs null
            if (!"".equals(edt_valor2.text.toString())) {
                val dados1 = intent.getParcelableExtra<Valores1>("dados1")
                var preco1 = edt_valor.text.toString().toFloat() / tamanho
                var preco2 =
                    dados1.valor1.toString().toFloat() / dados1.tamanho1.toString().toFloat()
                if (preco1 > preco2) {
                    var cervejaBarata = 1
                    var enviar =
                        Valores2(preco2.toString(), preco1.toString(), cervejaBarata.toString())
                    val enviarPara = Intent(this, Resultado::class.java)
                    enviarPara.putExtra("dados2", enviar)
                    startActivity(enviarPara)
                }
                if (preco2 > preco1) {

                    var cervejaBarata = 2
                    var enviar =
                        Valores2(preco1.toString(), preco2.toString(), cervejaBarata.toString())
                    val enviarPara = Intent(this, Resultado::class.java)
                    enviarPara.putExtra("dados2", enviar)
                    startActivity(enviarPara)
                }
                if (preco1 == preco2) {
                    var cervejaBarata = 3
                    var enviar =
                        Valores2(preco1.toString(), preco2.toString(), cervejaBarata.toString())
                    val enviarPara = Intent(this, Resultado::class.java)
                    enviarPara.putExtra("dados2", enviar)
                    startActivity(enviarPara)
                }
            } else {
                val alerta =
                    AlertDialog.Builder(this@Cerveja2)
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
            tamanho = 1000
        }
        if (posicao == 1) {
            tamamhos.text = "600 ml"
            tamanho = 600
        }
        if (posicao == 2) {
            tamamhos.text = "550 ml"
            tamanho = 550
        }
        if (posicao == 3) {
            tamamhos.text = "355 ml"
            tamanho = 355
        }
        if (posicao == 4) {
            tamamhos.text = "350 ml"
            tamanho = 350
        }
        if (posicao == 5) {
            tamamhos.text = "300 ml"
            tamanho = 300
        }

    }

    override fun onNothingSelected(arg0: AdapterView<*>) {
    }

    override fun onClick(v: View?) {
    }
}

