package com.ciopec.solitaire

import java.util.*

/**
 * Created by a626983 on 21.07.2017.
 */
class Deck {
    val cards = Array(52, { Card(it%13, getSuit(it)) })
    var cardsInDeck: MutableList<Card> = cards.toMutableList()

    fun drawCard(): Card = cardsInDeck.removeAt(0)

    fun reset() {
        cardsInDeck = cards.toMutableList()
        cardsInDeck.forEach { it.faceUp =false }
        Collections.shuffle(cardsInDeck)
    }

    private fun getSuit(i: Int) = when(i / 13) {
            0 -> clubs
            1 -> diamonds
            2 -> hearts
            else -> spades
        }

}