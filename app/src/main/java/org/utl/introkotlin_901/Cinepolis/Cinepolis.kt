package org.utl.introkotlin_901.Cinepolis

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.utl.introkotlin_901.R

class Cinepolis : AppCompatActivity() {

    private lateinit var nombreComprador: EditText
    private lateinit var cantCompradores: EditText
    private lateinit var yesRadioButton: RadioButton
    private lateinit var noRadioButton: RadioButton
    private lateinit var numBoletos: EditText
    private lateinit var costoTotal: TextView
    private lateinit var calcular: Button

    private val precioBoleto = 12.0
    private val maxBoletosPorPersona = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinepolis)

        nombreComprador = findViewById(R.id.nombreComprador)
        cantCompradores = findViewById(R.id.cantCompradores)
        yesRadioButton = findViewById(R.id.yesRadioButton)
        noRadioButton = findViewById(R.id.noRadioButton)
        numBoletos = findViewById(R.id.numBoletos)
        costoTotal = findViewById(R.id.costoTotal)
        calcular = findViewById(R.id.calcular)

        calcular.setOnClickListener {
            if (validarCampos()) {
                calcularPago()
            }
        }
    }

    private fun validarCampos(): Boolean {
        if (nombreComprador.text.isEmpty()) {
            mostrarToast("Ingrese nombre del comprador")
            return false
        }

        if (cantCompradores.text.isEmpty()) {
            mostrarToast("Ingrese cantidad de compradores")
            return false
        }

        if (numBoletos.text.isEmpty()) {
            mostrarToast("Ingrese cantidad de boletos")
            return false
        }

        val compradores = cantCompradores.text.toString().toInt()
        val boletos = numBoletos.text.toString().toInt()

        if (compradores <= 0) {
            mostrarToast("Compradores debe ser mayor a 0")
            return false
        }

        if (boletos <= 0) {
            mostrarToast("Boletos debe ser mayor a 0")
            return false
        }

        if (boletos > compradores * maxBoletosPorPersona) {
            mostrarToast("Máximo ${compradores * maxBoletosPorPersona} boletos")
            return false
        }

        return true
    }

    private fun calcularPago() {
        val boletos = numBoletos.text.toString().toInt()
        val tieneTarjeta = yesRadioButton.isChecked

        var subtotal = boletos * precioBoleto
        var descuento = 0.0


        if (boletos > 5) {
            descuento = 0.15
        } else if (boletos >= 3) {
            descuento = 0.10
        }


        var total = subtotal - (subtotal * descuento)


        if (tieneTarjeta) {
            total = total - (total * 0.10)
        }

        costoTotal.text = "$${"%.2f".format(total)}"
    }

    private fun mostrarToast(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}