package com.joshuacruz123.fundamentoskotlin.Reto4

import java.util.Scanner

class Reto4 {
}

fun main() {

    data class Plato(val codigo: Int, var nombre: String, var descripcion: String, var precio: Double)

    class MenuRestaurante {
        private val entrada = mutableListOf<Plato>()
        private val platoFuerte = mutableListOf<Plato>()
        private val postre = mutableListOf<Plato>()
        private val bebida = mutableListOf<Plato>()
        private var codigoActual = 1

        fun agregarPlato(categoria: String, nombre: String, descripcion: String, precio: Double) {
            when (categoria.toLowerCase()) {
                "entradas" -> entrada.add(Plato(codigoActual++, nombre, descripcion, precio))
                "platos fuertes" -> platoFuerte.add(Plato(codigoActual++, nombre, descripcion, precio))
                "postres" -> postre.add(Plato(codigoActual++, nombre, descripcion, precio))
                "bebidas" -> bebida.add(Plato(codigoActual++, nombre, descripcion, precio))
                else -> println("Categoría no válida.")
            }
        }

        fun mostrarPlatos() {
            println("---- MENÚ ----")
            println("Entradas:")
            entrada.forEach { mostrarPlato(it) }
            println("\nPlatos Fuertes:")
            platoFuerte.forEach { mostrarPlato(it) }
            println("\nPostres:")
            postre.forEach { mostrarPlato(it) }
            println("\nBebidas:")
            bebida.forEach { mostrarPlato(it) }
        }

        fun mostrarPlatoPorCodigo(codigo: Int) {
            val plato = buscarPlato(codigo)
            if (plato != null) {
                mostrarPlato(plato)
            } else {
                println("No se encontró el plato con código $codigo.")
            }
        }

        fun modificarMenu() {
            println("Ingrese el código del plato que desea modificar:")
            val codigo = readLine()?.toIntOrNull()
            if (codigo != null) {
                val plato = buscarPlato(codigo)
                if (plato != null) {
                    println("¿Qué desea modificar?")
                    println("1. Nombre")
                    println("2. Descripción")
                    println("3. Precio")
                    val opcion = readLine()?.toIntOrNull()
                    when (opcion) {
                        1 -> {
                            println("Ingrese el nuevo nombre:")
                            val nuevoNombre = readLine()
                            plato.nombre = nuevoNombre ?: plato.nombre
                        }
                        2 -> {
                            println("Ingrese la nueva descripción:")
                            val nuevaDescripcion = readLine()
                            plato.descripcion = nuevaDescripcion ?: plato.descripcion
                        }
                        3 -> {
                            println("Ingrese el nuevo precio:")
                            val nuevoPrecio = readLine()?.toDoubleOrNull()
                            if (nuevoPrecio != null) {
                                plato.precio = nuevoPrecio
                            } else {
                                println("Precio inválido.")
                            }
                        }
                        else -> println("Opción inválida.")
                    }
                } else {
                    println("No se encontró el plato con código $codigo.")
                }
            } else {
                println("Código inválido.")
            }
        }

        fun eliminarPlato(codigo: Int) {
            val plato = buscarPlato(codigo)
            if (plato != null) {
                when {
                    entrada.remove(plato) -> return
                    platoFuerte.remove(plato) -> return
                    postre.remove(plato) -> return
                    bebida.remove(plato) -> return
                }
            }
            println("No se encontró el plato con código $codigo.")
        }

        private fun mostrarPlato(plato: Plato) {
            println("Código: ${plato.codigo}")
            println("Nombre: ${plato.nombre}")
            println("Descripción: ${plato.descripcion}")
            println("Precio: ${plato.precio}")
            println("--------------------")
        }

        private fun buscarPlato(codigo: Int): Plato? {
            return entrada.find { it.codigo == codigo }
                ?: platoFuerte.find { it.codigo == codigo }
                ?: postre.find { it.codigo == codigo }
                ?: bebida.find { it.codigo == codigo }
        }
    }

    fun main() {
        val menuRestaurante = MenuRestaurante()
        val scanner = Scanner(System.`in`)

        var opcion: Int
        do {
            println("---- MENÚ DE RESTAURANTE ----")
            println("1. Agregar plato")
            println("2. Mostrar platos")
            println("3. Mostrar plato por código")
            println("4. Modificar menú")
            println("5. Eliminar plato")
            println("6. Salir")
            print("Ingrese una opción: ")
            opcion = scanner.nextInt()

            when (opcion) {
                1 -> {
                    println("Ingrese la categoría (Entradas / Platos Fuertes / Postres / Bebidas):")
                    val categoria = readLine()
                    println("Ingrese el nombre del plato:")
                    val nombre = readLine()
                    println("Ingrese la descripción del plato:")
                    val descripcion = readLine()
                    println("Ingrese el precio del plato:")
                    val precio = readLine()?.toDoubleOrNull()

                    if (categoria != null && nombre != null && descripcion != null && precio != null) {
                        menuRestaurante.agregarPlato(categoria, nombre, descripcion, precio)
                        println("Plato agregado con éxito.")
                    } else {
                        println("Datos inválidos. Inténtelo nuevamente.")
                    }
                }
                2 -> menuRestaurante.mostrarPlatos()
                3 -> {
                    println("Ingrese el código del plato:")
                    val codigo = readLine()?.toIntOrNull()
                    if (codigo != null) {
                        menuRestaurante.mostrarPlatoPorCodigo(codigo)
                    } else {
                        println("Código inválido.")
                    }
                }
                4 -> menuRestaurante.modificarMenu()
                5 -> {
                    println("Ingrese el código del plato que desea eliminar:")
                    val codigo = readLine()?.toIntOrNull()
                    if (codigo != null) {
                        menuRestaurante.eliminarPlato(codigo)
                    } else {
                        println("Código inválido.")
                    }
                }
                6 -> println("¡Hasta luego!")
                else -> println("Opción inválida. Inténtelo nuevamente.")
            }
            println("--------------------")
        } while (opcion != 6)
    }
}