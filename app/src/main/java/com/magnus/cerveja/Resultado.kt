package com.magnus.cerveja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_resultado.*

class Resultado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        val dados2 = intent.getParcelableExtra<Valores2>("dados2")
        if (dados2.cervejaBarata.toString().toInt() == 1) {
            cerveja.text =
                "A primeira cerveja é mais barata custando R$ ${dados2.valorFinal}\n\nSegunda cerveja custa R$ ${dados2.valorMaisCaro}"

        }
        if (dados2.cervejaBarata.toString().toInt() == 2) {
            cerveja.text =
                "A segunda cerveja é mais barata custando R$ ${dados2.valorFinal}\n\nPrimeira cerveja custa R$ ${dados2.valorMaisCaro}"
        }
        if (dados2.cervejaBarata.toString().toInt() == 3) {
            cerveja.text = "Os preços são guais R$ ${dados2.valorFinal}"
        }
        btn_voltar.setOnClickListener(View.OnClickListener {
            val voltar =
                Intent(this@Resultado, Cerveja2::class.java)
            startActivity(voltar)
            finish()
        })
    }
}
