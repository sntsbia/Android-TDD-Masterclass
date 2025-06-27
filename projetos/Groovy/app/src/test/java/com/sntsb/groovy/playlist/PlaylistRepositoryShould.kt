package com.sntsb.groovy.playlist

import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.sntsb.groovy.data.mapper.PlayListMapper
import com.sntsb.groovy.data.repository.PlaylistRepository
import com.sntsb.groovy.data.repository.PlaylistRepositoryImpl
import com.sntsb.groovy.data.services.PlaylistServiceImpl
import com.sntsb.groovy.domain.model.Playlist
import com.sntsb.groovy.domain.model.PlaylistRaw
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
    private val mapper: PlayListMapper = mock()
    private val playlists = mock<List<Playlist>>()
    private val playlistsRaw = mock<List<PlaylistRaw>>()
    private val expected = Result.success<List<PlaylistRaw>>(playlistsRaw)
    private val exception = Result.failure<List<PlaylistRaw>>(Exception("Something went wrong"))

    private fun callSuccessfulCaseRepository(): PlaylistRepository {
        runBlocking {
            whenever(service.fetchPlaylists()).thenReturn(
                flow {
                    emit(expected)
                })
        }
        whenever(mapper.invoke(playlistsRaw)).thenReturn(playlists)

        return PlaylistRepositoryImpl(service, mapper)
    }

    private fun callFailureCaseRepository(): PlaylistRepository {
        runBlocking {
            whenever(service.fetchPlaylists()).thenReturn(
                flow {
                    emit(exception)
                })
        }

        return PlaylistRepositoryImpl(service, mapper)
    }

    @Test
    fun delegateBusinessLogicToMapper() = runTest {

        val repository = callSuccessfulCaseRepository()

        repository.getPlaylists().first()

        verify(mapper, times(1)).invoke(playlistsRaw)
    }

    @Test
    fun getsPlaylistsFromService() = runTest {

        val repository = callSuccessfulCaseRepository()

        repository.getPlaylists().first()

        verify(service, times(1)).fetchPlaylists()

    }

    @Test
    fun emitMappedPlaylistsFromService() = runTest {

        val repository = callSuccessfulCaseRepository()

        assertEquals(playlists, repository.getPlaylists().first().getOrNull())

    }

    @Test
    fun propagateErrorWhenServiceFails() = runTest {

        val repository = callFailureCaseRepository()

        assertEquals(exception, repository.getPlaylists().first())

    }

}