package classes

abstract class Ranking<T> {
    // Attributes
    abstract var rankList: ArrayList<T>
    abstract var ratings: ArrayList<Double>
    abstract var oldRatings: ArrayList<Double>

    //Methods
    abstract fun size(): Int
    abstract fun get(index: Int): Any
    abstract fun add(newItem: T)
    // Añadir más con el tiempo :)
}