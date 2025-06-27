package com.sntsb.groovy.playlist.module

import com.sntsb.groovy.BuildConfig
import com.sntsb.groovy.data.api.PlaylistAPI
import com.sntsb.groovy.data.mapper.PlayListMapper
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
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object PlaylistModule {

    @Provides
    fun baseUrl(): String {
        // Access BuildConfig inside the function
        return BuildConfig.BASE_URL
    }

    @Provides
    fun retrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun playlistAPI(retrofit: Retrofit) = retrofit.create(PlaylistAPI::class.java)

    @Provides
    fun playlistRepository(
        playlistService: PlaylistService,
        mapper: PlayListMapper
    ): PlaylistRepository = PlaylistRepositoryImpl(playlistService, mapper)

    @Provides
    fun playlistService(playlistAPI: PlaylistAPI): PlaylistService =
        PlaylistServiceImpl(playlistAPI)

}