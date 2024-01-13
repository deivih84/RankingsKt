import classes.animes.AGenre
import classes.animes.Anime
import com.google.gson.Gson
import java.io.File
import kotlin.reflect.typeOf


fun main() {
    val jojo = Anime("Jojo", 6.0, 9.0, AGenre.Shounen)

// Almacenar
    val jsonString = Gson().toJson(jojo)
    File("animeFile.json").appendText(jsonString)

// Recuperar
    val jsonStringRecuperado = File("objeto1.json").readText()
    val objetoRecuperado: Anime = Gson().fromJson(jsonStringRecuperado, Anime::class.java)
    println(objetoRecuperado.genre)
}