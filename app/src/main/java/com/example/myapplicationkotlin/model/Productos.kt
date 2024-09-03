package com.example.myapplicationkotlin.model

class Productos constructor(nombre:String, precio:Double, productos:Int) {

   private var nombre:String = nombre
   private var precio:Double = precio
    private var  id_productos:Int = productos

    //get
    fun getNombre():String{
        return  nombre
    }
    fun getPrecio():Double{
        return  precio
    }
    fun getProductos():Int{
        return id_productos
    }
    //set
    fun setNombre(nombre: String){
        this.nombre= nombre
    }
    fun setPrecio(precio: Double){
        this.precio = precio
    }
    fun setProductos(productos: Int){
        this.id_productos=productos
    }
    fun calIVA(iva:Double): Double{
        val total:Double =precio * iva
        return total
    }
}