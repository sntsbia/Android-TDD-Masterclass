package com.sntsb.groovy.data.mapper

import com.sntsb.groovy.domain.model.Playlist
import com.sntsb.groovy.domain.model.PlaylistRaw
import javax.inject.Inject

class PlayListMapper @Inject constructor() : Function1<List<PlaylistRaw>, List<Playlist>> {
    override fun invoke(p1: List<PlaylistRaw>): List<Playlist> {
        TODO("Implement the mapping logic here")
//        return p1.map { playlistRaw ->
//            Playlist(
//                id = playlistRaw.id,
//                name = playlistRaw.name,
//                category = playlistRaw.category,
//                image = when (Category.from(playlistRaw.category)) {
//                    Category.rock -> {
//                        R.mipmap.rock
//                    }
//                    Category.house -> {
//                        R.mipmap.house
//                    }
//                    Category.mixed -> {
//                        R.mipmap.mixed
//                    }
//                    Category.jazz -> {
//                        R.mipmap.jazz
//                    }
//                    Category.pop -> {
//                        R.mipmap.pop
//                    }
//                    Category.electro -> {
//                        R.mipmap.electro
//                    }
//                    Category.none -> {
//                        R.mipmap.playlist
//                    }
//                }
//            )
//        }
    }

}
