package classes.animes

/**
 * Class that will caracterice each anime in the Ranking
 *
 * @property name The name :)
 * @property finalRating Impression after having watched the anime
 * @property initRating First impressions of the anime
 * @property genre Genre of the anime
 * @property nEpisodes Array of the number of episodes in each season/part
 */
class Anime(var name: String, var finalRating: Double?, var initRating: Double, val genre: AGenre, val nEpisodes: Array<Int>){
    constructor (name: String, initRating: Double, genre: AGenre, episodes: Array<Int>): this(name, null, initRating, genre, episodes)
}