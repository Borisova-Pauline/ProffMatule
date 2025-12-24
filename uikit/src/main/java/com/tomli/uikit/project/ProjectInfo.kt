package com.tomli.uikit.project

import android.net.Uri
import com.tomli.uikit.cards.category.MenuCategories

data class ProjectInfo (
    val id: Int,
    val type: ProjectType,
    val name: String,
    val dateStart: String,
    val dateFinish: String,
    val whom: ToWhom,
    val source: String,
    val category: MenuCategories,
    val image: Uri?
)