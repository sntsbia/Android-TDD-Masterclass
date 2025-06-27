package com.sntsb.groovy.data.mapper

import com.sntsb.groovy.R
import com.sntsb.groovy.domain.model.Playlist
import com.sntsb.groovy.domain.model.PlaylistRaw
import com.sntsb.groovy.domain.model.enums.Category
import javax.inject.Inject

class PlayListMapper @Inject constructor() : Function1<List<PlaylistRaw>, List<Playlist>> {
    override fun invoke(playlistsRaw: List<PlaylistRaw>): List<Playlist> {
        return playlistsRaw.map { playlistRaw ->
            val category = Category.from(playlistRaw.category)
            val imageID = when (category) {
                Category.rock -> R.mipmap.rock
                Category.house -> R.mipmap.house
                Category.mixed -> R.mipmap.mixed
                Category.jazz -> R.mipmap.jazz
                Category.pop -> R.mipmap.pop
                Category.electro -> R.mipmap.electro
                Category.none -> R.mipmap.playlist
            }
            Playlist(
                id = playlistRaw.id, name = playlistRaw.name, category = category, image = imageID
            )
        }
    }

}
