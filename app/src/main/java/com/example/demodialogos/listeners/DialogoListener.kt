package com.example.demodialogos.listeners

interface DialogoListener {
    // Funciones que queremos que escuche la clase

    fun onMissileFired(respuesta:String)

    fun onTimeSelected(isSelected:Boolean=false, hora:Int=0, minuto: Int=0)

    fun onListSelected(lista:ArrayList<String>)

    fun onDateSelected (isSelected:Boolean=false, anio:Int, mes:Int, dia:Int)

    fun onSingleSelected (topping:String )

    fun onSingInSuccess (username:String, password: String)

    fun onTimeEdtSelected(isSelected:Boolean=false, hora:Int=0, minuto: Int=0)

    fun onDateEdtSelected (isSelected:Boolean=false, anio:Int, mes:Int, dia:Int)

}