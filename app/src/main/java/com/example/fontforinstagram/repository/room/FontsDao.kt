package com.example.fontforinstagram.repository.room

import androidx.room.*

@Dao
interface FontsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFont(favoriteFonts: FavoriteFonts)

    @Query("SELECT * FROM favorite_fonts_table")
    suspend fun getllAllFonts() : List<FavoriteFonts>

    @Update
    suspend fun updateFavorite(favoriteFonts: FavoriteFonts)

    @Query("DELETE FROM favorite_fonts_table WHERE id = :id")
    suspend fun deleteById(id : Int)

    @Query("DELETE FROM favorite_fonts_table")
    suspend fun deleteAll()
}