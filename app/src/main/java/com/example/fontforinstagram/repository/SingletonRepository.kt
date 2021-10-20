package com.example.fontforinstagram.repository

import android.content.Context
import androidx.room.Room
import com.example.fontforinstagram.repository.room.FontsDataBase

object SingletonRepository {

    fun dataBaseFonts(context : Context): FontsDataBase {
        val db = Room.databaseBuilder(
            context, FontsDataBase::class.java, "favoriteFons"
        ).build()
        return db
    }
}