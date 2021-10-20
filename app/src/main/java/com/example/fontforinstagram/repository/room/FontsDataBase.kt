package com.example.fontforinstagram.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [FavoriteFonts::class], version = 1)
abstract class FontsDataBase : RoomDatabase() {
    abstract fun fontsDao(): FontsDao
}