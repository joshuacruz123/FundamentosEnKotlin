package com.joshuacruz123.fundamentoskotlin.Reto2

class Reto2 {
}

fun main() {
    print("Aplicación de reproducción de musica")
    class Cancion(val titulo: String, val artista: String, val annoPublicacion: Int, var reproducciones: Int) {
        fun obtenerDescripcion(): String {
            return "$titulo, interpretada por $artista, se lanzó en $annoPublicacion, $reproducciones reproducciones."
        }
    }

    class Album(val tipoMusica: String) {
        private val canciones: MutableList<Cancion> = mutableListOf()

        fun agregarCancion(cancion: Cancion) {
            canciones.add(cancion)
        }

        fun obtenerNumeroDeCanciones(): Int {
            return canciones.size
        }

        fun obtenerCancionMasPopular(): Cancion? {
            return canciones.maxByOrNull { it.reproducciones }
        }

        fun obtenerCancionesPopulares(): List<Cancion> {
            return canciones.filter { it.reproducciones >= 1000 }
        }

        fun imprimirDescripcionCanciones() {
            for (cancion in canciones) {
                println(cancion.obtenerDescripcion())
            }
        }
    }

    fun main() {
        val album = Album("Pop")

        album.agregarCancion(Cancion("Cancion 1", "Artista 1", 2023, 2000))
        album.agregarCancion(Cancion("Cancion 2", "Artista 2", 2023, 1500))
        album.agregarCancion(Cancion("Cancion 3", "Artista 3", 2023, 800))
        album.agregarCancion(Cancion("Cancion 4", "Artista 4", 2023, 3000))

        println("El álbum tiene ${album.obtenerNumeroDeCanciones()} canciones.")
        println("Tipo de música del álbum: ${album.tipoMusica}")

        val cancionMasPopular = album.obtenerCancionMasPopular()
        if (cancionMasPopular != null) {
            println("La canción más popular del álbum es: ${cancionMasPopular.titulo}")
        } else {
            println("No se encontró la canción más popular del álbum.")
        }

        println("Canciones populares:")
        for (cancion in album.obtenerCancionesPopulares()) {
            println(cancion.titulo)
        }

        println("Descripción de las canciones:")
        album.imprimirDescripcionCanciones()
    }
}