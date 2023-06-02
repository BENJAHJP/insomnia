package com.example.superheroes.di

import com.example.superheroes.common.Constants
import com.example.superheroes.common.LoggingInterceptor
import com.example.superheroes.data.api.Api
import com.example.superheroes.data.repository.SuperheroRepositoryImpl
import com.example.superheroes.domain.repository.SuperheroRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesOKHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(LoggingInterceptor())
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient): Api{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideSuperheroRepository(api: Api): SuperheroRepository{
        return SuperheroRepositoryImpl(api)
    }
}