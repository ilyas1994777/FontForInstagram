package com.example.fontforinstagram.repository.room.favoriteFontsClassic

import androidx.room.*

@Dao
interface FontsClassicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFontClassic(favoriteClassic: FavoriteClassic)

    @Query("SELECT * FROM favorite_fonts_classic")
    suspend fun getAllFontsClassic() : List<FavoriteClassic>

    @Update
    suspend fun updateFontsClassic(favoriteClassic: FavoriteClassic)

    @Query("SELECT * FROM favorite_fonts_classic WHERE id = :id")
    suspend fun isLiked(id : Int) : List<FavoriteClassic>

    @Query("DELETE FROM favorite_fonts_classic WHERE id = :id")
    suspend fun deleteById(id : Int)
}