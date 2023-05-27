package com.example.superheroes.di

import com.example.superheroes.common.Constants
import com.example.superheroes.data.api.Api
import com.example.superheroes.data.repository.SuperheroRepositoryImpl
import com.example.superheroes.domain.repository.SuperheroRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): Api{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideSuperheroRepository(api: Api): SuperheroRepository{
        return SuperheroRepositoryImpl(api)
    }
}