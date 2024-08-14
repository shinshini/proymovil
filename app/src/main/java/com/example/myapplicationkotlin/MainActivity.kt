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
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: MaterialButton
    private lateinit var txtPrecio: TextInputEditText
    private lateinit var tvResul: MaterialTextView
    private lateinit var spLista: Spinner
    private lateinit var listpro: ListView
    private lateinit var textNombre: TextInputEditText

    private lateinit var productoList: MutableList<String>
    private lateinit var adapterlistView: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        cargarR()

        // Configurar el Spinner
        val listaPaises = arrayOf("USA", "BOL", "ESP")
        val adaptador1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaPaises)
        spLista.adapter = adaptador1

        // Configurar el botón
        btnCalcular.setOnClickListener {
            calcularIVA()
        }

        // Cargar datos iniciales
        cargarListaproducto()
    }

    private fun cargarR() {
        btnCalcular = findViewById(R.id.btnCalcularIVA)
        txtPrecio = findViewById(R.id.txtProducto)
        tvResul = findViewById(R.id.tvResultado)
        spLista = findViewById(R.id.spPaises)
        listpro = findViewById(R.id.listaProductos)
        textNombre = findViewById(R.id.txtNombre)
    }

    private fun calcularIVA() {
        // Obtener el nombre y el precio ingresado por el usuario
        val nombreProducto = textNombre.text.toString()
        val precioProducto = txtPrecio.text.toString().toDoubleOrNull()

        if (precioProducto == null) {
            Toast.makeText(this, "Por favor ingrese un precio válido", Toast.LENGTH_SHORT).show()
            return
        }

        val iva = when (spLista.selectedItem?.toString()) {
            "USA" -> precioProducto * 0.03
            "BOL" -> precioProducto * 0.13
            "ESP" -> precioProducto * 0.05
            else -> {
                Toast.makeText(this, "Por favor seleccione un país válido", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // Añadir el resultado a la lista
        val resultado = "${nombreProducto}, \$${precioProducto}, IVA: \$${iva}"
        productoList.add(resultado)
        adapterlistView.notifyDataSetChanged()
        tvResul.text = resultado
    }

    private fun cargarListaproducto() {
        productoList = mutableListOf()
        adapterlistView = ArrayAdapter(this, android.R.layout.simple_list_item_1, productoList)
        listpro.adapter = adapterlistView
    }
}