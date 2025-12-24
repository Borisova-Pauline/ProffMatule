package com.tomli.uikit.cards

import com.tomli.uikit.cards.category.MenuCategories

data class CardSupply(
    val id: Int,
    val name: String,
    val price: Int,
    var isAdded: Boolean,
    val category: MenuCategories,
    val description: List<DescrSections>
){
    data class DescrSections(
        val section: String,
        val descr: String
    )
}