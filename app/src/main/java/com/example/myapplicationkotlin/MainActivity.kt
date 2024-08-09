package com.example.myapplicationkotlin

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationkotlin.model.Productos

class MainActivity : AppCompatActivity() {
    lateinit var btnCalcular: Button
    lateinit var txtPrecio: EditText
    lateinit var tvResul: TextView
    lateinit var spLista: Spinner
    lateinit var listpro: ListView

    lateinit var productoList : MutableList <String>
    lateinit var adapterlistView : ArrayAdapter <String>
    lateinit var  textNombre : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //codigo
        cargarR()
        estadoOnclick()
        cargarListaproducto()

        //cargar listad e datos en spinner
        val listaPaises = arrayOf("USA", "BOL", "ESP")
        val adaptador1 =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaPaises)
        spLista.adapter = adaptador1


    }

    fun cargarR() {
        btnCalcular = findViewById(R.id.btnCalcularIVA)
        txtPrecio = findViewById(R.id.txtProducto)
        tvResul = findViewById(R.id.tvResultado)
        spLista = findViewById(R.id.spPaises)
        listpro = findViewById(R.id.listaProductos)
        textNombre= findViewById(R.id.txtNombre)
    }

    private fun estadoOnclick() {
        btnCalcular.setOnClickListener {
            // Obtener el nombre y el precio ingresado por el usuario
            val nombreProducto = textNombre.text.toString()
            val precioProducto = txtPrecio.text.toString().toDoubleOrNull()

            if (precioProducto == null) {
                Toast.makeText(this, "Por favor ingrese un precio válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crear la instancia de Productos con los datos proporcionados por el usuario
            val laptop = Productos(nombreProducto, precioProducto)

            // Aquí, laptop.nombre ya contiene el valor que ingresó el usuario
            // No necesitas asignarle un nuevo valor
            val iva: Double

            when (spLista.selectedItem?.toString()) {
                "USA" -> iva = laptop.calIVA(0.03)
                "BOL" -> iva = laptop.calIVA(0.13)
                "ESP" -> iva = laptop.calIVA(0.05)
                else -> {
                    Toast.makeText(this, "Por favor seleccione un país válido", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            // Añadir el resultado a la lista
            productoList.add("${laptop.nombre}, $precioProducto, IVA: $iva")
            adapterlistView.notifyDataSetChanged()
        }
    }

    fun cargarListaproducto(){

        // val productos= arrayOf("LAPTOP", "MOUSE")
        productoList = mutableListOf("3500")
        adapterlistView= ArrayAdapter(this, android.R.layout.simple_list_item_1,productoList)
        listpro.adapter = adapterlistView
    }
}