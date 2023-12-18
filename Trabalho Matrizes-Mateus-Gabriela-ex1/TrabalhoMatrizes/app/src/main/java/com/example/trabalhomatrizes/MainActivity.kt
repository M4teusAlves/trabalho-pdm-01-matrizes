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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etValor = findViewById(R.id.et_valor)
        btnInserir = findViewById(R.id.btn_inserir)
        btnLimpar = findViewById(R.id.btn_limpar)
        btnCalcular = findViewById(R.id.btn_calcular)
        tvResultado = findViewById(R.id.tv_resultado)

        var listaElementos = ArrayList<Float>()
        var matriz  = Array(5){IntArray(5)}
        var tam:Int = 0


        btnInserir.setOnClickListener{
            if(tam<25){
                listaElementos.add(etValor.text.toString().toFloat())
            }else{
                Toast.makeText(this, "Limite Excedido", Toast.LENGTH_LONG).show()
            }
            etValor.text.clear()
            tam++
        }

        btnLimpar.setOnClickListener {
            for(i in 0 .. 4 step 1)
            {
                for(j in 0 .. 4)
                {
                    matriz[i][j] = 0
                }

            }
            tam = 0
        }

        btnCalcular.setOnClickListener {
            if(tam<25){
                Toast.makeText(this, "Falta Elementos", Toast.LENGTH_LONG).show()
            }else{
                var k:Int = 0
                var linha3Soma = 0
                var coluna2soma = 0
                var somaDiagonalPrincipal = 0
                var somaDiagonalSegundária = 0
                var somaTotal = 0
                for(i in 0 .. 4 step 1)
                {
                    for(j in 0 .. 4)
                    {
                        matriz[i][j] = listaElementos.get(k).toInt()
                        k++
                    }

                }

                for(l in 0 .. 4 step 1)
                {

                    for(m in 0 .. 4)
                    {   somaTotal = somaTotal + matriz[l][m]
                        if( l == 2)
                            linha3Soma = linha3Soma + matriz[l][m]
                        if( m == 1)
                            coluna2soma = coluna2soma + matriz[l][m]
                        if( l == m)
                            somaDiagonalPrincipal = somaDiagonalPrincipal + matriz[l][m]
                        if(l + m == 4)
                            somaDiagonalSegundária = somaDiagonalSegundária + matriz[l][m]
                    }

                }
                tvResultado.text = "Soma linha 3 : ${linha3Soma} \n Soma coluna 2: ${coluna2soma} \n Soma da diagonal principal: ${somaDiagonalPrincipal} \n Soma da diagonal secundária: ${somaDiagonalSegundária} \n Soma total da matriz: ${somaTotal}"


                for(i in 0 .. 4 step 1)
                {
                    for(j in 0 .. 4)
                    {
                        matriz[i][j] = 0
                    }

                }


            }
        }

    }
}