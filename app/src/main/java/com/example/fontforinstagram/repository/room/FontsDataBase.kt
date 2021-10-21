package com.example.fontforinstagram.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fontforinstagram.repository.room.favoriteFontsClassic.FavoriteClassic
import com.example.fontforinstagram.repository.room.favoriteFontsClassic.FontsClassicDao
import com.example.fontforinstagram.repository.room.favoriteFontsColorfull.FavoriteFonts
import com.example.fontforinstagram.repository.room.favoriteFontsColorfull.FontsDao


@Database(entities = [FavoriteFonts::class, FavoriteClassic::class], version = 1)
abstract class FontsDataBase : RoomDatabase() {
    abstract fun fontsDao(): FontsDao
    abstract fun fontsClassic() : FontsClassicDao

}