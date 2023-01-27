package com.dscoding.startingpoint.di

import com.dscoding.startingpoint.data.api.SpApi
import com.dscoding.startingpoint.data.repository.RepositoryImpl
import com.dscoding.startingpoint.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(SpApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideSpApi(retrofit: Retrofit): SpApi =
        retrofit.create(SpApi::class.java)

    @Provides
    @Singleton
    fun provideSpRepository(api: SpApi): Repository {
        return RepositoryImpl(api)
    }
}