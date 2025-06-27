package com.sntsb.groovy.playlist.module

import com.sntsb.groovy.data.api.PlaylistAPI
import com.sntsb.groovy.data.repository.PlaylistRepository
import com.sntsb.groovy.data.repository.PlaylistRepositoryImpl
import com.sntsb.groovy.data.services.PlaylistService
import com.sntsb.groovy.data.services.PlaylistServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class PlaylistModule {

    @Provides
    fun retrofit() = Retrofit.Builder().baseUrl("http://192.168.0.199:3001/").client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun playlistAPI(retrofit: Retrofit) = retrofit.create(PlaylistAPI::class.java)

    @Provides
    fun playlistRepository(playlistService: PlaylistService): PlaylistRepository =
        PlaylistRepositoryImpl(playlistService)

    @Provides
    fun playlistService(playlistAPI: PlaylistAPI): PlaylistService =
        PlaylistServiceImpl(playlistAPI)

}