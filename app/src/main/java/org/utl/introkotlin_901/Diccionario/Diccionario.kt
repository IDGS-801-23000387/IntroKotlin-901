package org.utl.introkotlin_901.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.Cinepolis.Cinepolis
import org.utl.introkotlin_901.R
import org.utl.introkotlin_901.ejemplo1.SumaActivity

class Diccionario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diccionario)

        val btnCapturarPalabras = findViewById<Button>(R.id.btnCapturar)
        btnCapturarPalabras.setOnClickListener { navegateToCapturarPalabras()  }

        val btnBuscarPalabras = findViewById<Button>(R.id.btnBuscar)
        btnBuscarPalabras.setOnClickListener { navegateToBuscarPalabras()  }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun navegateToCapturarPalabras(){
        val intent = Intent(this,  CapturarPalabras::class.java)
        startActivity(intent)
    }
    private fun navegateToBuscarPalabras(){
        val intent = Intent(this, BuscarPalabras::class.java)
        startActivity(intent)
    }
}