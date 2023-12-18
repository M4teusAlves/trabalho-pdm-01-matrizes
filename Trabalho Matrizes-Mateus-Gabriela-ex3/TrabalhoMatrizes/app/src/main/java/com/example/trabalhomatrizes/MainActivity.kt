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
    lateinit var btnBuscar: Button
    lateinit var tvAviso : TextView
    lateinit var etX : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etValor = findViewById(R.id.et_valor)
        btnInserir = findViewById(R.id.btn_inserir)
        btnLimpar = findViewById(R.id.btn_limpar)
        btnBuscar = findViewById(R.id.btn_buscar)
        tvAviso = findViewById(R.id.tv_aviso)
        etX = findViewById(R.id.et_x)

        var listaElementosA= ArrayList<Float>()
        var matrizG  = Array(5){IntArray(5)}

        var tam:Int = 0


        btnInserir.setOnClickListener{
            if(tam<25){
                var flag = 0;
                if(tam == 0){
                    listaElementosA.add(etValor.text.toString().toFloat())
                    tam++
                }else{
                    for (l in listaElementosA){
                        if(l==etValor.text.toString().toFloat()){
                            flag = 1
                        }
                    }
                    if (flag == 0){
                        listaElementosA.add(etValor.text.toString().toFloat())
                        tvAviso.text = "Pode Seguir!"
                        tam++
                    }else{
                        tvAviso.text = "Digite outro elemento, pois esse já pertence à matriz!"
                    }
                }

            } else{
                Toast.makeText(this, "Limite Excedido", Toast.LENGTH_LONG).show()
            }
            etValor.text.clear()

        }

        btnLimpar.setOnClickListener {
            listaElementosA.clear()
            tam = 0
        }

        btnBuscar.setOnClickListener {
            if(tam<25){
                Toast.makeText(this, "Falta Elementos", Toast.LENGTH_LONG).show()
            }else{
                var k:Int = 0
                var flag = 0

                tvAviso.text = "O elemento não pertence a matriz!"

                for(i in 0 .. 4 step 1)
                {
                    for(j in 0 .. 4)
                    {
                        matrizG[i][j] = listaElementosA.get(k).toInt()
                        if(matrizG[i][j] == etX.text.toString().toFloat().toInt() ){
                            flag = 1
                        }
                        k++
                    }

                }

                if(flag == 1){
                    tvAviso.text = "O elemento pertence a matriz!"
                }




                etX.text.clear()






            }
        }

    }
}