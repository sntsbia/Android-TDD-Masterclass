package com.sntsb.groovy.playlist

import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.sntsb.groovy.data.model.Playlist
import com.sntsb.groovy.data.repository.PlaylistRepository
import com.sntsb.groovy.data.repository.PlaylistRepositoryImpl
import com.sntsb.groovy.data.services.PlaylistServiceImpl
import com.sntsb.groovy.utils.BaseUnitTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock

class PlaylistRepositoryShould : BaseUnitTest() {

    private val service: PlaylistServiceImpl = mock()

    private val playlists = mock<List<Playlist>>()
    private val expected = Result.success<List<Playlist>>(playlists)
    private val exception = Result.failure<List<Playlist>>(Exception("Something went wrong"))

    private fun callSuccessfulCaseRepository(): PlaylistRepository {
        runBlocking {
            whenever(service.fetchPlaylists()).thenReturn(
                flow {
                    emit(expected)
                })
        }

        return PlaylistRepositoryImpl(service)
    }

    private fun callFailureCaseRepository(): PlaylistRepository {
        runBlocking {
            whenever(service.fetchPlaylists()).thenReturn(
                flow {
                    emit(exception)
                })
        }

        return PlaylistRepositoryImpl(service)
    }

    @Test
    fun getsPlaylistsFromService() = runTest {

        val repository = PlaylistRepositoryImpl(service)

        repository.getPlaylists()

        verify(service, times(1)).fetchPlaylists()

    }

    @Test
    fun emitPlaylistsFromService() = runTest {

        val repository = callSuccessfulCaseRepository()

        assertEquals(expected, repository.getPlaylists().first())

    }

    @Test
    fun propagateErrorWhenServiceFails() = runTest {

        val repository = callFailureCaseRepository()

        assertEquals(exception, repository.getPlaylists().first())

    }

}