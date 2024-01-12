package classes

import kotlin.math.max

class Animes: Ranking<String>() {

    // Attributes
    override var rankList: ArrayList<String> = arrayListOf()
    override var ratings: ArrayList<Double> = arrayListOf()
    override var oldRatings: ArrayList<Double> = arrayListOf()
    // Methods
    override fun add(newItem: String) {
        rankList.add(newItem)
    }
    override fun size(): Int {
        return rankList.size
    }
    override fun get(index: Int): String {
        return rankList[index]
    }

    // Custom methods
    private fun topAnime(): String {
        return rankList[0]
    }
    private fun worstAnime(): String {
        return rankList.last()
    }
    private fun topFirstImpresion(): String {
        return rankList[findBiggest(oldRatings)]
    }

    /**
     * TODO Verify that every possible error is covered
     * It returns the position of the biggest double in the list.
     *
     * @param doubleList Your double ArrayList.
     * @return Position of the first and biggest value.
     */
    private fun findBiggest(doubleList: ArrayList<Double>): Int {
        if (doubleList.isEmpty()){
            throw IllegalArgumentException("The list is EMPTY")
        }
        var max = 0.0 // Value of the max
        var pos = 0 // Position of the max
        for (i in 0..doubleList.size) {
            if (doubleList[i] > max) {
                max = max(doubleList[i], max)
                pos = i
            }
        }
        return pos
    }
}