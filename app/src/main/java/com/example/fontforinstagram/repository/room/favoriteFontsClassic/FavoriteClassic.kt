package com.example.fontforinstagram.repository.room.favoriteFontsClassic

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favorite_fonts_classic")
data class FavoriteClassic(

    @PrimaryKey
    var id : Int,
    var imageFont : Int,
    var isLike : Int
)
