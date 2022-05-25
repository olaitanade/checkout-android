package com.tayo.checkoutsample.di

import android.content.Context
import com.tayo.checkoutsample.data.model.Ticket
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.*
import javax.inject.Singleton
import kotlin.collections.ArrayList

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun providesTickets(@ApplicationContext context: Context): ArrayList<Ticket> {
        return arrayListOf(
            Ticket("1", "2022-09-29T16:55:00","Childish Gambino", 40.0,""),
            Ticket("2", "2022-12-29T17:55:00","Vince Staples", 20.0,""),
        )
    }
}