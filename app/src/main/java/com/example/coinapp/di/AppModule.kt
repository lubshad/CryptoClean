package com.example.coinapp.di

import com.example.coinapp.domain.usecase.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetCoinsUseCase(): GetCoinsUseCase {
        return GetCoinsUseCase()
    }
}