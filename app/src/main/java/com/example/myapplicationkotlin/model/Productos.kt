package com.example.myapplicationkotlin.model

class Productos constructor(nombre:String, precio:Double) {

   private var nombre:String = nombre
   private var precio:Double = precio

    //get
    fun getNombre():String{
        return  nombre
    }
    fun getPrecio():Double{
        return  precio
    }
    //set
    fun setNombre(nombre: String){
        this.nombre= nombre
    }
    fun setPrecio(precio: Double){
        this.precio = precio
    }
    fun calIVA(iva:Double): Double{
        val total:Double =precio * iva
        return total
    }
}