package com.example.fontforinstagram

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dinuscxj.gesture.MultiTouchGestureDetector
import com.example.fontforinstagram.ViewMovingText.ViewMovingText
import com.example.fontforinstagram.ViewStartWindowStickers.ViewStickers
import com.google.android.material.bottomnavigation.BottomNavigationView


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