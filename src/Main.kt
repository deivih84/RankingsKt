import classes.animes.AGenre
import classes.animes.Anime
import com.google.gson.Gson
import java.io.File
import kotlin.reflect.typeOf


fun main() {
    val jojo = Anime("Jojo", 6.0, 9.0, AGenre.Shounen)
    val evangelion = Anime("Evangelion", 8.5, 7.5, AGenre.Mecha)

/*// Almacenar
    val jsonString = Gson().toJson(jojo)
    File("animeFile.json").appendText(jsonString)

// Recuperar
    val jsonStringRecuperado = File("objeto1.json").readText()
    val objetoRecuperado: Anime = Gson().fromJson(jsonStringRecuperado, Anime::class.java)
    println(objetoRecuperado.genre)*/


    // Crear un ArrayList de números desordenados
    val numeros = arrayListOf(jojo, evangelion)

    // Ordenar en orden ascendente y crear una nueva lista ordenada
    // Imprimir la lista original y la lista ordenada
    println("Lista original: $numeros")
}