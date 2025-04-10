package com.example.seekhoappassignment.di

import com.example.seekhoappassignment.data.remote.AnimeApiService
import com.example.seekhoappassignment.utils.UtilitiesConstants.API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAnimeApiService(retrofit: Retrofit): AnimeApiService =
        retrofit.create(AnimeApiService::class.java)
}
