package com.example.seekhoappassignment.di

import com.example.seekhoappassignment.data.remote.AnimeApiService
import com.example.seekhoappassignment.data.repository.AnimeRepositoryImpl
import com.example.seekhoappassignment.domain.repository.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAnimeRepository(
        apiService: AnimeApiService,
    ): AnimeRepository {
        return AnimeRepositoryImpl(apiService)
    }
}