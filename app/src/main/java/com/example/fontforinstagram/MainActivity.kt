package com.example.fontforinstagram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fontforinstagram.botton_navigation.button_ViewStickers.ViewStickers


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Singleton.mainActivity = this

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.emptyFragment, ViewStickers())
            commit()
        }


    }



}