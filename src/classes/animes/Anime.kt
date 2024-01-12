package classes.animes

class Anime (var name: String, var finalRating: Double?, var initRating: Double, val genre: AGenre){
    constructor (name: String, initRating: Double, genre: AGenre): this(name, null, initRating, genre)
}