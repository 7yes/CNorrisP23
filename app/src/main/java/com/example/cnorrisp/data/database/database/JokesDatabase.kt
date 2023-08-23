package com.example.cnorrisp.data.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cnorrisp.data.database.dao.JokesDao
import com.example.cnorrisp.data.database.entities.ChuckEntity

@Database (entities = [ChuckEntity::class], version = 1)
abstract class JokesDatabase:RoomDatabase(){
    abstract fun getJokesDao():JokesDao
}
