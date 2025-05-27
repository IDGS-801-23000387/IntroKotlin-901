package org.utl.introkotlin_901.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R

class CapturarPalabras : AppCompatActivity() {
    private val fileName = "diccionario.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar_palabras)

        val txtIngles = findViewById<EditText>(R.id.txtIngles)
        val txtEspanol = findViewById<EditText>(R.id.txtEspanol)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)


        btnGuardar.setOnClickListener {
            val palabraIngles = txtIngles.text.toString().trim()
            val palabraEspanol = txtEspanol.text.toString().trim()

            if (palabraIngles.isNotEmpty() && palabraEspanol.isNotEmpty()) {
                val linea = "$palabraIngles:$palabraEspanol\n"
                try {
                    openFileOutput(fileName, MODE_APPEND).use {
                        it.write(linea.toByteArray())
                    }
                    Toast.makeText(this, "Palabras guardadas correctamente", Toast.LENGTH_SHORT).show()
                    txtIngles.text.clear()
                    txtEspanol.text.clear()
                } catch (e: Exception) {
                    Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Completa ambos campos", Toast.LENGTH_SHORT).show()
            }
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

    private fun navegateToMenu() {
        val intent = Intent(this, Diccionario::class.java)
        startActivity(intent)
    }
}
