package com.example.myapplicationkotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {

    lateinit var btnIvaPro: CardView
    lateinit var btnPro: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()

        estadoBoton()

    }

    fun cargarR(){
        btnIvaPro = findViewById(R.id.btn_calcularIVA)
        btnPro = findViewById(R.id.btn_producto)
    }

    fun estadoBoton(){
        btnIvaPro.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)

        }
        btnPro.setOnClickListener{
            val i = Intent(this, RegistraProductos::class.java)
            startActivity(i)
    }

    }
}