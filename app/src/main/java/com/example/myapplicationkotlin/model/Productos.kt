package com.example.myapplicationkotlin.model

class Productos constructor(nombre:String, precio:Double) {

    var nombre: String = nombre
        get() = field // 'field' es el respaldo de la propiedad, no necesitas modificar esto si no tienes lógica adicional.
        set(value) {
            field = value
            // Aquí puedes agregar lógica si lo necesitas, como validaciones.
        }

    var precio: Double = precio
        get() = field
        set(value) {
            field = value
            // Agrega cualquier lógica adicional para manejar cambios en el precio.
        }

    fun calIVA(iva: Double): Double {
        return precio * iva
    }

}