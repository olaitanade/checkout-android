package com.tayo.checkoutsample.di

import com.tayo.checkoutsample.repository.CheckoutRepository
import com.tayo.checkoutsample.repository.CheckoutRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun providesRepository(repositoryImpl: CheckoutRepositoryImpl): CheckoutRepository
}