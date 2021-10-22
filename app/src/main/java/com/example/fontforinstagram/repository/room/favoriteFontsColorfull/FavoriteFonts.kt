package com.example.fontforinstagram.repository.room.favoriteFontsColorfull

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_fonts_table")

data class FavoriteFonts(
// если не хотим чтобы ключи создавались автоматом а к примеру зависи от позиции recycler view
    // оставляем @PrimaryKey пустым, а если хотим чтобы ключи генерировались автоматом ты пишем
    //  @PrimaryKey(autoGenerate = true)
    @PrimaryKey
    var id : Int,
    var imageFont : Int,
    var iconLike : Int

)





