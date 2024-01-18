package classes.animes

import classes.Ranking
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class AnimeRanking: Ranking<Anime>() {

    // Attributes
    override var rankList: ArrayList<Anime> = arrayListOf()
    private var ratings: ArrayList<Double?> = arrayListOf()
    private var initRatings: ArrayList<Double> = arrayListOf()

    // Methods
    override fun loadRanking(){
        // Create and deserialize a TypeToken that represents a list of anime objects
        rankList = Gson().fromJson(File("animeFile.json").readText(), object : TypeToken<ArrayList<Anime>>() {}.type)
    }

    /**
     * TODO Hacer el array en el que van englobados todos los objetos
     *
     */
    override fun saveRanking(){

    }
    override fun size(): Int {
        return rankList.size
    }
    override fun get(index: Int): Anime {
        return rankList[index]
    }

    // Custom methods
    override fun organizeRanking() {
        if (rankList.any{ it.finalRating == null }) {
            throw IllegalStateException("There are still some Animes to rank.")
        // You can´t list the animes if you haven´t rated them all yet
        } else{
            quicksort(rankList, 0, rankList.size - 1)
        }
    }

    fun addAnime(newItem: String, rating: Double?, initRating: Double, genre: AGenre) {
        if (rating == null){
            rankList.add(Anime(newItem, initRating, genre))
        } else {
            rankList.add(Anime(newItem, rating, initRating, genre))
        }
    }
    private fun topAnime(): Anime {
        return rankList[0]
    }
    private fun worstAnime(): Anime {
        return rankList[indexSmallest(rankList)]
    }
    private fun topFirstImpresion(): Anime {
        return rankList[indexBiggest(rankList)]
    }

    /**
     * Returns the position of the biggest double in the list.
     *
     * @param doubleList Your double ArrayList.
     * @throws IllegalArgumentException if the list is empty
     * @throws IllegalStateException if the animes aren´t rated yet
     * @return Position of the first and biggest value.
     */
    private fun indexBiggest(doubleList: ArrayList<Anime>): Int {
        if (doubleList.isEmpty()){
            throw IllegalArgumentException("The list is EMPTY")
        }
        var max = 0.0 // Value of the max
        var pos = 0 // Position of the max
        for (i in 0..doubleList.size) {
            if (doubleList[i].finalRating != null && doubleList[i].finalRating!! > max) {
                pos = i // Update i if necessary
                max = doubleList[i].finalRating!!
            }
        }
        if (max == 0.0) {
            throw IllegalStateException("The list doesn´t have any rated animes yet")
        }
        return pos
    }

    /**
     * Returns the position of the smallest double in the list.
     *
     * @param doubleList Your double ArrayList.
     * @throws IllegalArgumentException If the list is empty
     * @throws IllegalStateException If the animes aren´t rated yet
     * @return Position of the first and biggest value.
     */
    private fun indexSmallest(doubleList: ArrayList<Anime>): Int {
        if (doubleList.isEmpty()){
            throw IllegalArgumentException("The list is EMPTY")
        }
        var min = 10.0 // Value of the min
        var pos = 0 // Position of the max
        for (i in 0..doubleList.size) {
            if (doubleList[i].finalRating != null && doubleList[i].finalRating!! < min) {
                pos = i // Update i if necessary
                min = doubleList[i].finalRating!!
            }
        }
        if (min == 10.0) {
            throw IllegalStateException("The list doesn´t have any rated animes yet")
        }
        return pos
    }

    override fun toString(): String {
        return "AnimeRanking(rankList=$rankList, ratings=$ratings, initRatings=$initRatings)"
    }

    override fun quicksort(arr: ArrayList<Anime>, start: Int, end: Int) {
        if (start < end) {
            val pivotIndex = partition(arr, start, end)
            quicksort(arr, start, pivotIndex - 1)
            quicksort(arr, pivotIndex + 1, end)
        }
    }

    private fun partition(arr: ArrayList<Anime>, start: Int, end: Int): Int {
        val pivot = arr[end]
        var i = start - 1

        for (j in start..<end) {
            if (arr[j].finalRating!! <= pivot.finalRating!!) {
                i++
                // Swap arr[i] and arr[j]
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }

        // Swap arr[i + 1] and arr[end] (placing the pivot in its final position)
        val temp = arr[i + 1]
        arr[i + 1] = arr[end]
        arr[end] = temp

        return i + 1
    }


}