package com.tomli.uikit.cart

import com.tomli.uikit.cards.CardSupply

data class CardExtended(
    val baseCard: CardSupply,
    var quantity: Int
)