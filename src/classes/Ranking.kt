package classes

abstract class Ranking<T> {
    // Attributes
    abstract var rankList: ArrayList<T>

    //Methods
    abstract fun loadRanking()
    abstract fun size(): Int
    abstract fun get(index: Int): Any
//    abstract fun add(newItem: T)
    // Añadir más con el tiempo :)
}