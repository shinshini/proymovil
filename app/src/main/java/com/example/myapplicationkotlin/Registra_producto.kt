package com.example.myapplicationkotlin

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationkotlin.db.AdminSQLiteOpenHelper

class Registra_producto : AppCompatActivity() {

         lateinit var btnregistrar: Button
         lateinit var  txtNombre: EditText
         lateinit var  txtprecio: EditText
         lateinit var  ttx_codigo: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registra_producto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        cargarR()
        estadoBotn()
    }
    fun cargarR(){
        btnregistrar=findViewById(R.id.btn_registrarProducto);
        txtprecio=findViewById(R.id.txt_precio);
        txtNombre=findViewById(R.id.txtNombre);
        ttx_codigo=findViewById(R.id.txt_codigo);
    }

 fun estadoBotn(){
     btnregistrar.setOnClickListener{
         val adminsql= AdminSQLiteOpenHelper(this,"administracion", null ,1)
         val db = adminsql.writableDatabase
         val registro = ContentValues()
         registro.put("id_productos",ttx_codigo.text.toString())
         registro.put("nombre",txtNombre.text.toString())
         registro.put("precio",txtprecio.text.toString())
         db.insert("productos",null,registro)

         ttx_codigo.setText("")
         txtNombre.setText("")
         txtprecio.setText("")
         Toast.makeText(this, "Se cargaron los datos del producto", Toast.LENGTH_SHORT).show()
     }
 }

}