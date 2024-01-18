package classes

import classes.animes.Anime

abstract class Ranking<T> {
    // Attributes
    abstract var rankList: ArrayList<T>

    //Methods
    abstract fun loadRanking()
    abstract fun organizeRanking()
    abstract fun quicksort(arr: ArrayList<T>, start: Int, end: Int)
    abstract fun saveRanking()
    abstract fun size(): Int
    abstract fun get(index: Int): Any
//    abstract fun add(newItem: T)
    // Añadir más con el tiempo :)
}