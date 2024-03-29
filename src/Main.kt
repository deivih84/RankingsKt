import classes.animes.AGenre
import classes.animes.Anime

//
import com.google.gson.Gson
import java.io.File
//

fun main() {

    val jojo = Anime("Jojo", 6.0, 9.0, AGenre.Shounen, arrayOf(9, 17, 48, 39, 39, 38))
    val evangelion = Anime("Evangelion", 8.5, 7.5, AGenre.Mecha, arrayOf(26))

// Almacenar

    val jsonString = Gson().toJson(arrayOf(jojo, evangelion))
//    val jsonString = Gson().toJson(jojo)

    File("classes/animes/animeFile.json").writeText(jsonString) // Kotlin lo ciera el solito 🤯

// Recuperar
/*    val jsonStringRecuperado = File("objeto1.json").readText()
    val objetoRecuperado: Anime = Gson().fromJson(jsonStringRecuperado, Anime::class.java)
    println(objetoRecuperado.genre)*/


    // Crear un ArrayList de números desordenados
    val numeros = arrayListOf(jojo, evangelion)

    // Ordenar en orden ascendente y crear una nueva lista ordenada
    // Imprimir la lista original y la lista ordenada
    println("Lista original: $numeros")
}