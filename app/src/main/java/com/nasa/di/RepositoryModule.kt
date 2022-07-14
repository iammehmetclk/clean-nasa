package com.nasa.di

import com.nasa.data.remote.NasaApi
import com.nasa.data.repository.NasaRepositoryImpl
import com.nasa.domain.repository.NasaRepository
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
    fun provideNasaRepository(api: NasaApi): NasaRepository {
        return NasaRepositoryImpl(api)
    }

}