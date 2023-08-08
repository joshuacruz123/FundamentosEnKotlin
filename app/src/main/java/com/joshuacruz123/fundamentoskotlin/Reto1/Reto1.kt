package com.joshuacruz123.fundamentoskotlin.Reto1

class Reto1 {
}

fun main() {
    var respuesta = 1
    var i = 0
    var cantidad = 0
    println("¿Deseas escribir una respuesta?\n Si escribes 1, escribiras otra respuesta.\n Si escribes 0, onitiras esta opción.")
    respuesta = readLine()!!.toInt()
    while (respuesta==1){
        println("Escribe un mensaje:")
        readLine()!!.toString()
        i += 1
        println("¿Deseas escribir otra respuesta?\n Si escribes 1, escribiras otra respuesta.\n Si escribes 0, veras el numero de notificaciones.")
        respuesta = readLine()!!.toInt()
        cantidad +=1
    }

    if (cantidad > 0){
        if(cantidad >= 100){
            print("Has recibido $cantidad notificaciones.")
        }else {
            print("Has recibido 99+ notificaciones.")
        }
    } else {
        println("No existen mensajes disponibles.")
    }
}
