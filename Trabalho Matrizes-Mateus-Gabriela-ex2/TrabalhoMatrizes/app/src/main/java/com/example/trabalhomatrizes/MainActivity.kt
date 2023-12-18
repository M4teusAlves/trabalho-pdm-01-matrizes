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
        var listaElementosB= ArrayList<Float>()
        var matrizA  = Array(4){IntArray(6)}
        var matrizB  = Array(4){IntArray(6)}

        var tam:Int = 0


        btnInserir.setOnClickListener{
            if(tam<24){
                listaElementosA.add(etValor.text.toString().toFloat())
            }else if(tam==24){
                listaElementosB.add(etValor.text.toString().toFloat())
                Toast.makeText(this, "Matriz A Preenchida", Toast.LENGTH_LONG).show()
                tvAviso.text = "Digite os valores para a matriz B:"
            }else if(tam>24 && tam<48){
                listaElementosB.add(etValor.text.toString().toFloat())

            }else{
                Toast.makeText(this, "Limite Excedido", Toast.LENGTH_LONG).show()
            }
            etValor.text.clear()
            tam++
        }

        btnLimpar.setOnClickListener {
            listaElementosA.clear()
            listaElementosB.clear()
        }

        btnCalcular.setOnClickListener {
            if(tam<48){
                Toast.makeText(this, "Falta Elementos", Toast.LENGTH_LONG).show()
            }else{
                var k:Int = 0

                var matrizS  = Array(4){IntArray(6)}
                var matrizD  = Array(4){IntArray(6)}

                for(i in 0 .. 3 step 1)
                {
                    for(j in 0 .. 5)
                    {
                        matrizA[i][j] = listaElementosA.get(k).toInt()
                        matrizB[i][j] = listaElementosB.get(k).toInt()
                        matrizS[i][j] = matrizA[i][j]+matrizB[i][j]
                        matrizD[i][j] = matrizA[i][j]-matrizB[i][j]
                        k++
                    }

                }

                tvResultado.text = "Soma das Matrizes \n"

                for(i in 0 .. 3 step 1)
                {
                    for(j in 0 .. 5)
                    {
                        tvResultado.text = "${tvResultado.text} ${matrizS[i][j]}"
                    }
                    tvResultado.text = "${tvResultado.text}\n"

                }

                tvResultado.text = "${tvResultado.text}\nSubtração de Matrizes\n"

                for(i in 0 .. 3 step 1)
                {
                    for(j in 0 .. 5)
                    {
                        tvResultado.text = "${tvResultado.text} ${matrizD[i][j]}"
                    }
                    tvResultado.text = "${tvResultado.text}\n"

                }


                for(i in 0 .. 3 step 1)
                {
                    for(j in 0 .. 5)
                    {
                        matrizA[i][j] = 0
                        matrizB[i][j] = 0
                    }

                }
            listaElementosA.clear()
            listaElementosB.clear()


            }
        }

    }
}