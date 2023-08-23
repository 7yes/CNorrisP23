package com.example.cnorrisp.di

import android.content.Context
import androidx.room.Room
import com.example.cnorrisp.data.database.database.JokesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private val JOKES_DATABASE_NAME = "jokes_database"

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, JokesDatabase::class.java, JOKES_DATABASE_NAME).build()


    @Provides
    @Singleton
    fun providesJokesDao(db: JokesDatabase) = db.getJokesDao()
}