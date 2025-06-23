package com.sntsb.groovy.playlist

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.sntsb.groovy.data.api.PlaylistAPI
import com.sntsb.groovy.data.model.Playlist
import com.sntsb.groovy.data.services.PlaylistServiceImpl
import com.sntsb.groovy.utils.BaseUnitTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock

class PlaylistServiceShould : BaseUnitTest() {

    private val api: PlaylistAPI = mock()

    private val playlists = mock<List<Playlist>>()
    private val expected = Result.success(playlists)
    private val error = RuntimeException("Damn you, network!")

    private fun setupSuccessulCaseAPI(): PlaylistServiceImpl {
        runBlocking {
            whenever(api.fetchAllPlaylists()).thenReturn(playlists)
        }
        return PlaylistServiceImpl(api)
    }

    private fun setupFailureCaseAPI(): PlaylistServiceImpl {
        runBlocking {
            whenever(api.fetchAllPlaylists()).thenThrow(
                error
            )
        }

        return PlaylistServiceImpl(api)
    }

    @Test
    fun fetchAllPlaylistsFromAPI() = runTest {
        val service = PlaylistServiceImpl(api)

        service.fetchPlaylists().first()

        verify(api).fetchAllPlaylists()
    }

    @Test
    fun convertValuesToFlowResultAndEmitsThem() = runTest {

        val service = setupSuccessulCaseAPI()

        assertEquals(expected, service.fetchPlaylists().first())

    }

    @Test
    fun emitsErrorWhenNetworkFails() = runTest {

        val service = setupFailureCaseAPI()

        assertEquals(
            "Something went wrong",
            service.fetchPlaylists().first().exceptionOrNull()?.message
        )
    }

}