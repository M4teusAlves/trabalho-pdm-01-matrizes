package com.example.trabalhomatrizes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etValor : EditText
    lateinit var btnInserir : Button
    lateinit var btnLimpar : Button
    lateinit var btnCalcular: Button
    lateinit var tvResultado : TextView
    lateinit var tvAviso : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etValor = findViewById(R.id.et_valor)
        btnInserir = findViewById(R.id.btn_inserir)
        btnLimpar = findViewById(R.id.btn_limpar)
        btnCalcular = findViewById(R.id.btn_calcular)
        tvResultado = findViewById(R.id.tv_resultado)
        tvAviso = findViewById(R.id.tv_aviso)

        var listaElementosA= ArrayList<Float>()
        var matrizG  = Array(5){IntArray(5)}

        var tam:Int = 0


        btnInserir.setOnClickListener{
            if(tam<25){
                listaElementosA.add(etValor.text.toString().toFloat())
            } else{
                Toast.makeText(this, "Limite Excedido", Toast.LENGTH_LONG).show()
            }
            etValor.text.clear()
            tam++
        }

        btnLimpar.setOnClickListener {
            listaElementosA.clear()
        }

        btnCalcular.setOnClickListener {
            if(tam<25){
                Toast.makeText(this, "Falta Elementos", Toast.LENGTH_LONG).show()
            }else{
                var k:Int = 0
                var SL = IntArray(5)
                var SC = IntArray(5)

                for(i in 0 .. 4 step 1)
                {
                    for(j in 0 .. 4)
                    {
                        matrizG[i][j] = listaElementosA.get(k).toInt()
                        SL[i] = SL[i] + matrizG[i][j]
                        SC[j] = SC[j] + matrizG[i][j]
                        k++
                    }

                }



                tvResultado.text = "Soma de linhas:\n"

                for(i in 0 .. 4 step 1)
                {

                    tvResultado.text = "${tvResultado.text} ${SL[i]}"

                }

                tvResultado.text = "${tvResultado.text}\nSoma de colunas:\n"

                for(i in 0 .. 4 step 1)
                {

                    tvResultado.text = "${tvResultado.text} ${SC[i]}"

                }

                for(i in 0 .. 4 step 1)
                {
                    for(j in 0 .. 4)
                    {
                        matrizG[i][j] = 0
                    }

                }

            listaElementosA.clear()

                tam = 0

            }
        }

    }
}