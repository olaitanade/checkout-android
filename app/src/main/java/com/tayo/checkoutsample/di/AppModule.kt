package com.tayo.checkoutsample.di

import android.content.Context
import com.tayo.checkoutsample.data.model.Ticket
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun providesTickets(@ApplicationContext context: Context): ArrayList<Ticket> {
        return arrayListOf(

        )
    }
}