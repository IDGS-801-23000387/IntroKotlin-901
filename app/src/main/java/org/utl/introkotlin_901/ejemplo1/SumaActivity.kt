package org.utl.introkotlin_901.ejemplo1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R

class SumaActivity : AppCompatActivity() {

    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var rbSuma: RadioButton
    private lateinit var rbResta: RadioButton
    private lateinit var rbMultiplicacion: RadioButton
    private lateinit var rbDivision: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suma)
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        rbSuma = findViewById(R.id.rbSuma)
        rbResta = findViewById(R.id.rbResta)
        rbMultiplicacion = findViewById(R.id.rbMultiplicacion)
        rbDivision = findViewById(R.id.rbDivision)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun calcular(view: View){
        val num1 = et1.text.toString().toDouble()
        val num2 = et2.text.toString().toDouble()
        var resultado = 0.0

        if (rbSuma.isChecked) {
            resultado = num1 + num2
        } else if (rbResta.isChecked) {
            resultado = num1 - num2
        } else if (rbMultiplicacion.isChecked) {
            resultado = num1 * num2
        } else if (rbDivision.isChecked) {
            resultado = num1 / num2
        }

        tv1.text = "Resultado: $resultado"
    }
}