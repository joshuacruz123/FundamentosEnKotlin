package com.joshuacruz123.fundamentoskotlin.Reto5

class Nequi {
}

fun main(){
    println("Crea tu cuenta de Nequi colombia")
    println("Escribe tu nombre:")
    var nombre:String =readLine()!!.toString()
    println("Digita tu número de celular:")
    var numeroCelular:Int =readLine()!!.toInt()
    println("Crea una contraseña de 4 digitos:")
    var contrasenna:Int =readLine()!!.toInt()
    var intentos = 3
    fun codigo(): Int {
        return (100000..999999).random()
    }
    while (intentos >0){
        println("Número de celular:")
        var it:Int =readLine()!!.toInt()
        println("Contraseña de 4 digitos")
        var ct:Int =readLine()!!.toInt()
        if (it == numeroCelular && ct == contrasenna) {
            break
        }else {
            if (intentos > 0) {
                println("¡Upps! Parece que tus datos de acceso no son correctos, Tienes tres intentos más:")
            } else {
                println("Acceso denegado >:(")
                return
            }
        }
    }
    println("Bienvenid@ $nombre.")
    var saldo = 4500
    while (true){
        println("Opciones:")
        println("1. Saca")
        println("2. Envía")
        println("3. Recarga")
        println("4. Salir")

        println("Digita la opción que deseas hacer:")
        var decicion = readLine()!!.toInt()

        when (decicion){
            1 -> {
                println("1.cajero")
                println("2.punto fisico")
                var ds = readLine()!!.toInt()
                if (saldo < 2000){
                    println("No te alcanza.")
                }else{
                    println("¿Cuanto deseas retirar?")
                    var retiro = readLine()!!.toInt()
                    if (retiro <= saldo) {
                        saldo -= retiro
                        println("El código para el retiro es ${codigo()}")
                        println("El retiro es todo un exito.")
                    }else{
                        println("El saldo es insuficiente para hacer el retiro")
                    }
                }
            }
            2 -> {
                print("Ingresa el número telefonico a la persona que enviaras el dinero:")
                val tele = readLine()!!.toInt()
                print("Digita cuanto dinero deseas enviar: ")
                val envio = readLine()!!.toInt()
                if (envio <= saldo) {
                    saldo -= envio
                    println("Envío exitoso.\n El saldo que tienes es de $saldo")
                } else {
                    println("El saldo es insuficiente para hacer el envío.")
                }
            }
            3 -> {
                print("Ingresa cuanto dinero deseas recargar: ")
                val recarga = readLine()!!.toInt()
                print("¿Deseas realizar la recarga? (Sí o No): ")
                val confirmacion = readLine()
                if (confirmacion == "Sí") {
                    saldo += recarga
                    println("La recarga fue exitosa.\n Saldo disponible: $saldo")
                } else {
                    println("La recarga fue cancelada.")
                }

            }
            4 -> {
                print("¿Deseas salir de aquí? (Sí o No): ")
                val confirmacion = readLine()
                if (confirmacion == "Sí") {
                    println("Saliendo de la aplicación Nequi.")
                    break
                }else {
                    println("La opción es invalida o la escribiste mal.")
                }
            }
        }
    }
}