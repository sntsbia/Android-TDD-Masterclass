package com.sntsb.groovy.playlist

import com.sntsb.groovy.R
import com.sntsb.groovy.data.mapper.PlayListMapper
import com.sntsb.groovy.domain.model.PlaylistRaw
import com.sntsb.groovy.domain.model.enums.Category
import com.sntsb.groovy.utils.BaseUnitTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PlaylistMapperShould : BaseUnitTest() {

    private val playlistRaw = PlaylistRaw(
        id = "1",
        name = "playlist name",
        category = "playlist category",
    )

    private val playlistRawRock = PlaylistRaw(
        id = "1",
        name = "playlist name",
        category = "rock",
    )

    private val playlistRawHouse = PlaylistRaw(
        id = "1",
        name = "playlist name",
        category = "house",
    )

    private val playlistRawMixed = PlaylistRaw(
        id = "1",
        name = "playlist name",
        category = "mixed",
    )

    private val playlistRawJazz = PlaylistRaw(
        id = "1",
        name = "playlist name",
        category = "jazz",
    )

    private val playlistRawPop = PlaylistRaw(
        id = "1",
        name = "playlist name",
        category = "pop",
    )

    private val playlistRawElectro = PlaylistRaw(
        id = "1",
        name = "playlist name",
        category = "electro",
    )

    private val mapper = PlayListMapper()

    private val playlists = mapper(
        listOf(
            playlistRaw,
            playlistRawRock,
            playlistRawHouse,
            playlistRawMixed,
            playlistRawJazz,
            playlistRawPop,
            playlistRawElectro
        )
    )
    private val playlistDefault = playlists.first { it.category == Category.none }
    private val playlistRock = playlists.first { it.category == Category.rock }
    private val playlistHouse = playlists.first { it.category == Category.house }
    private val playlistMixed = playlists.first { it.category == Category.mixed }
    private val playlistJazz = playlists.first { it.category == Category.jazz }
    private val playlistPop = playlists.first { it.category == Category.pop }
    private val playlistElectro = playlists.first { it.category == Category.electro }

    @Test
    fun keepSameId() = runTest {
        assertEquals(playlistRaw.id, playlistDefault.id)
    }

    @Test
    fun keepSameName() = runTest {
        assertEquals(playlistRaw.name, playlistDefault.name)
    }

    @Test
    fun keepSameCategory() = runTest {
        assertEquals(Category.from(playlistRaw.category), playlistDefault.category)
    }

    @Test
    fun mapDefaultImage() = runTest {
        assertEquals(R.mipmap.playlist, playlistDefault.image)
    }

    @Test
    fun mapRockImageWhenRockCategory() = runTest {
        assertEquals(R.mipmap.rock, playlistRock.image)
    }

    @Test
    fun mapHouseImageWhenHouseCategory() = runTest {
        assertEquals(R.mipmap.house, playlistHouse.image)
    }

    @Test
    fun mapMixedImageWhenMixedCategory() = runTest {
        assertEquals(R.mipmap.mixed, playlistMixed.image)
    }

    @Test
    fun mapJazzImageWhenJazzCategory() = runTest {
        assertEquals(R.mipmap.jazz, playlistJazz.image)
    }

    @Test
    fun mapPopImageWhenPopCategory() = runTest {
        assertEquals(R.mipmap.pop, playlistPop.image)
    }

    @Test
    fun mapElectroImageWhenElectroCategory() = runTest {
        assertEquals(R.mipmap.electro, playlistElectro.image)
    }

}