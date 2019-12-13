// Ranks
const val RANK_2 = 2
const val RANK_3 = 3
const val RANK_4 = 4
const val RANK_5 = 5
const val RANK_6 = 6
const val RANK_7 = 7
const val RANK_8 = 8
const val RANK_9 = 9
const val RANK_10 = 10
const val RANK_J = 11
const val RANK_Q = 12
const val RANK_K = 13
const val RANK_A = 14

const val RANK_SMALL_JOKER = 15
const val RANK_BIG_JOKER = 16

fun rankToString(rank: Int): String =
    when (rank) {
        RANK_2 -> "2"
        RANK_3 -> "3"
        RANK_4 -> "4"
        RANK_5 -> "5"
        RANK_6 -> "6"
        RANK_7 -> "7"
        RANK_8 -> "8"
        RANK_9 -> "9"
        RANK_10 -> "10"
        RANK_J -> "J"
        RANK_Q -> "Q"
        RANK_K -> "K"
        RANK_A -> "A"
        RANK_SMALL_JOKER -> "xx"
        RANK_BIG_JOKER -> "XX"
        else -> throw IllegalArgumentException("Unrecognized rank")
    }

// Suits
const val CLUBS = 0
const val DIAMONDS = 1
const val HEARTS = 2
const val SPADES = 3
const val JOKER = 4

fun suitToString(suit: Int): String =
    when (suit) {
        CLUBS -> "C"
        DIAMONDS -> "D"
        HEARTS -> "H"
        SPADES -> "S"
        JOKER -> ""
        else -> throw IllegalArgumentException("Unrecognized suit")
    }

fun createDeck(): List<Card> = intArrayOf(CLUBS, DIAMONDS, HEARTS, SPADES, JOKER).flatMap { suit ->
    when (suit) {
        JOKER -> intArrayOf(RANK_SMALL_JOKER, RANK_BIG_JOKER).map{ rank ->
            Card(rank, suit)
        }
        else -> (RANK_2..RANK_A).map{ rank ->
            Card(rank, suit)
        }
    }
}

data class Card(val rank: Int, val suit: Int) {
    override fun toString(): String = rankToString(rank) + suitToString(suit)
}