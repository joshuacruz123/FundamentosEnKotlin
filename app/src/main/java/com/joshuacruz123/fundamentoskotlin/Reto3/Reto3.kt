package com.joshuacruz123.fundamentoskotlin.Reto3

class Reto3 {
}

fun main() {
    println("Digita cuantas subastas quieres hacer:")
    var respuesta = readLine()!!.toInt()
    for (i in 1 .. respuesta) {
        println("Digita el nombre del producto:")
        var nombre = readLine()!!.toString()
        println("Digita el precio del producto (en decimales):")
        var producto = readLine()!!.toDouble()
        println("¿Cuanto da el candidato 1?:")
        var candidato1 = readLine()!!.toDouble()
        println("¿Cuanto da el candidato 2?:")
        var candidato2 = readLine()!!.toDouble()
        println("¿Cuanto da el candidato 3?:")
        var candidato3 = readLine()!!.toDouble()
        if (producto > candidato1 && producto > candidato2 && producto > candidato3) {
            print("El producto se subastó se vende automáticamente a la casa de subastas al precio mínimo.")
        } else if (producto < candidato1 && producto < candidato2 && producto < candidato3) {
            if (candidato1 > candidato2 && candidato1 > candidato3) {
                print("El producto se vende al candidato # 1 por $candidato1.")
            } else if (candidato2 > candidato1 && candidato2 > candidato3) {
                print("El producto se vende al candidato # 2 por $candidato2.")
            } else if (candidato3 > candidato1 && candidato3 > candidato2) {
                print("El producto se vende al candidato # 3 por $candidato3.")
            }
        }
    }
}