package classes

abstract class Ranking {
    // Attributes
    abstract var rankList: ArrayList<Any>
    abstract var grades: ArrayList<Double>

    //Methods
    abstract fun size(): Int
    abstract fun getTop(mejor: Int): Any
    // Añadir más con el tiempo :)
}