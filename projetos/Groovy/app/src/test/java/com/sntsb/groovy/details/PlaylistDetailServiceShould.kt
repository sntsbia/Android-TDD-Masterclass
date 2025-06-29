package com.sntsb.groovy.details

import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.sntsb.groovy.data.api.PlaylistAPI
import com.sntsb.groovy.data.services.PlaylistDetailsServiceImpl
import com.sntsb.groovy.domain.model.PlaylistDetail
import com.sntsb.groovy.utils.BaseUnitTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock

class PlaylistDetailServiceShould : BaseUnitTest() {

    private val api = mock<PlaylistAPI>()

    private val playlistDetail = mock<PlaylistDetail>()

    private val expected = Result.success(playlistDetail)
    private val error = RuntimeException("Damn you, network!")
    private val exception = Result.failure<PlaylistDetail>(error)

    private val id = "100"

    private fun setupSuccessfulCaseAPI(): PlaylistDetailsServiceImpl {
        runBlocking {
            whenever(api.fetchPlaylistDetails(id)).thenReturn(
                playlistDetail
            )
        }
        return PlaylistDetailsServiceImpl(api)
    }

    private fun setupFailureCaseAPI(): PlaylistDetailsServiceImpl {
        runBlocking {
            whenever(api.fetchPlaylistDetails(id)).thenThrow(error)
        }

        return PlaylistDetailsServiceImpl(api)

    }

    @Test
    fun fetchPlaylistDetailsFromAPI() = runTest {
        val service = setupSuccessfulCaseAPI()

        service.fetchPlaylistDetails(id).single()

        verify(api, times(1)).fetchPlaylistDetails(id)
    }

    @Test
    fun convertValuesToFlowResultAndEmitsThem() = runTest {
        val service = setupSuccessfulCaseAPI()

        assertEquals(expected, service.fetchPlaylistDetails(id).single())
    }

    @Test
    fun emitErrorResultWhenNetworkFails() = runTest {
        val service = setupFailureCaseAPI()

        assertEquals(
            "Something went wrong",
            service.fetchPlaylistDetails(id).single().exceptionOrNull()?.message
        )
    }

}