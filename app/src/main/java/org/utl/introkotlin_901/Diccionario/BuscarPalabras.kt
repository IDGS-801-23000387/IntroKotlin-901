package org.utl.introkotlin_901.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R
import java.io.BufferedReader
import java.io.InputStreamReader

class BuscarPalabras : AppCompatActivity() {

    private val fileName = "diccionario.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar_palabras)

        val txtBuscar = findViewById<EditText>(R.id.txtBuscar)
        val txtIngles = findViewById<RadioButton>(R.id.txtIngles)
        val txtEspanol = findViewById<RadioButton>(R.id.txtEspanol)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnBuscar.setOnClickListener {
            val palabra = txtBuscar.text.toString().trim()
            if (palabra.isEmpty()) {
                Toast.makeText(this, "Escribe una palabra", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultado = buscarEnArchivo(palabra, txtIngles.isChecked)

            // Mostrar el resultado como ventana (AlertDialog)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Resultado de la búsqueda")
            builder.setMessage(resultado)
            builder.setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

        btnRegresar.setOnClickListener {
            navegateToMenu()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun buscarEnArchivo(palabra: String, buscarPorIngles: Boolean): String {
        try {
            val lector = BufferedReader(InputStreamReader(openFileInput(fileName)))
            var linea: String?
            while (lector.readLine().also { linea = it } != null) {
                val partes = linea!!.split(":")
                if (partes.size == 2) {
                    val ingles = partes[0].trim()
                    val espanol = partes[1].trim()
                    if (buscarPorIngles && palabra.equals(ingles, ignoreCase = true)) {
                        return "Español: $espanol"
                    } else if (!buscarPorIngles && palabra.equals(espanol, ignoreCase = true)) {
                        return "Inglés: $ingles"
                    }
                }
            }
            lector.close()
        } catch (e: Exception) {
            e.printStackTrace()
            return "Error al leer archivo"
        }
        return "Palabra no encontrada"
    }

    private fun navegateToMenu() {
        val intent = Intent(this, Diccionario::class.java)
        startActivity(intent)
    }
}
