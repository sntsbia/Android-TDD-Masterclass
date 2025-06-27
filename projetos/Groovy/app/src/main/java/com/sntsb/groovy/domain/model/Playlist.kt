package com.sntsb.groovy.domain.model

import com.sntsb.groovy.domain.model.enums.Category

data class Playlist(
    val id: String, val name: String, val category: Category, val image: Int
)