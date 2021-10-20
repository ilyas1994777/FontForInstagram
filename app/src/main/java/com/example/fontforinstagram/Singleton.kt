package com.example.fontforinstagram

import android.annotation.SuppressLint
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dinuscxj.gesture.MultiTouchGestureDetector


object Singleton {

    var mainActivity : MainActivity? = null

    fun switchFragment(fm : Fragment){
        mainActivity?.supportFragmentManager!!.beginTransaction().apply {
            replace(R.id.emptyFragment, fm)
            addToBackStack(null)
            commit()
        }
    }



}