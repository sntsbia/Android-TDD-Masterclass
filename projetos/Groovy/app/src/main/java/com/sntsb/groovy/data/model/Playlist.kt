package com.sntsb.groovy.data.model

import com.sntsb.groovy.R

data class Playlist (
    val id: String,
    val name: String,
    val category: String,
    val image: Int = R.mipmap.playlist
)