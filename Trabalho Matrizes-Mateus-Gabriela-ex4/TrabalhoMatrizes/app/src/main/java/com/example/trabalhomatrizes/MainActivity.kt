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
        var matrizA  = Array(12){FloatArray(13)}

        var tam:Int = 0


        btnInserir.setOnClickListener{
            if(tam<156){
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
            if(tam<156){
                Toast.makeText(this, "Falta Elementos", Toast.LENGTH_LONG).show()
            }else{
                var k:Int = 0

                for(i in 0 .. 11 step 1)
                {
                    for(j in 0 .. 12)
                    {
                        matrizA[i][j] = listaElementosA.get(k)
                        k++
                    }

                }

                for(i in 0 .. 11 step 1)
                {
                    var aux = 0.0f
                    for(j in 0 .. 12)
                    {
                        if(j==0){
                            aux = matrizA[i][j]
                        }else if(aux<matrizA[i][j]){
                            aux=matrizA[i][j]
                        }
                    }

                    for(j in 0 .. 12)
                    {
                        matrizA[i][j] = matrizA[i][j]/aux
                    }

                }

                tvResultado.text = "Matriz A Alterada:\n"

                for(i in 0 .. 11 step 1)
                {
                    for(j in 0 .. 12)
                    {
                        tvResultado.text = "${tvResultado.text} ${matrizA[i][j]} , "
                    }
                    tvResultado.text = "${tvResultado.text}\n"

                }

                for(i in 0 .. 11 step 1)
                {
                    for(j in 0 .. 12)
                    {
                        matrizA[i][j] = 0.0f

                    }

                }
            listaElementosA.clear()



            }
        }

    }
}