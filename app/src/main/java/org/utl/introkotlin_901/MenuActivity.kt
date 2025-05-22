package org.utl.introkotlin_901

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.Cinepolis.Cinepolis
import org.utl.introkotlin_901.Ejemplo2.SaludoActivity
import org.utl.introkotlin_901.ejemplo1.SumaActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSaludo = findViewById<Button>(R.id.btn1)
        btnSaludo.setOnClickListener { navegateTosaludo()  }

        val btnCinepolis = findViewById<Button>(R.id.btn2)
        btnCinepolis.setOnClickListener { navegateToCinepolis()  }

        val btnEjemplo2 = findViewById<Button>(R.id.btn3)
        btnEjemplo2.setOnClickListener { navegateToEjemplo2()  }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateTosaludo(){
        val intent = Intent(this, SumaActivity::class.java)
        startActivity(intent)
    }
    private fun navegateToCinepolis(){
        val intent = Intent(this, Cinepolis::class.java)
        startActivity(intent)
    }

    private fun navegateToEjemplo2(){
        val intent = Intent(this, SaludoActivity::class.java)
        startActivity(intent)
    }
}