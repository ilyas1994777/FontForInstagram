package com.example.fontforinstagram.viewLikes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.fontforinstagram.R


class ViewFavoritesLikes : Fragment(), View.OnClickListener {

    private enum class EnumState{
        Default,
        Stickers,
        Colorful,
        CLassic
    }

    private var buttonStickersLikes : Button? = null
    private var buttonColorfulLikes : Button? = null
    private var buttonClassicLikes : Button? = null
    private var listButton = arrayListOf<Button>()
    private var enumState = EnumState.Default
    set(value) {
        field = value
        when(enumState){
            EnumState.Stickers -> {
              switchStateButton(buttonStickersLikes!!)
            }
            EnumState.Colorful -> {
                Toast.makeText(context, "qwe", Toast.LENGTH_SHORT).show()
                switchStateButton(buttonColorfulLikes!!)
            }
            EnumState.CLassic -> {
                switchStateButton(buttonClassicLikes!!)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_favorites_likes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        listButton.add(buttonStickersLikes!!)
        listButton.add(buttonColorfulLikes!!)
        listButton.add(buttonClassicLikes!!)
        
        buttonStickersLikes!!.setOnClickListener(this)
        buttonColorfulLikes!!.setOnClickListener(this)
        buttonClassicLikes!!.setOnClickListener(this)





    }


    fun init(){
        buttonStickersLikes = view?.findViewById(R.id.buttonStickersLikes)!!
        buttonColorfulLikes = view?.findViewById(R.id.buttonColorfulLikes)!!
        buttonClassicLikes = view?.findViewById(R.id.buttonClassicLikes)!!
    }

    private fun switchStateButton(button: Button){
        for (i in 0..listButton.count() - 1){
            if (listButton[i] ==  button){
                listButton[i].setTextColor(resources.getColor(R.color.orange))
                listButton[i].background = resources.getDrawable(R.drawable.back_buttons_fonts_classic)
            } else {

                listButton[i].background = resources.getDrawable(R.drawable.back_buttons_fons_classic_disable)
                listButton[i].setTextColor(resources.getColor(R.color.white))

            }

        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonStickersLikes -> {
                enumState = EnumState.Stickers
            }
            R.id.buttonColorfulLikes -> {
                enumState = EnumState.Colorful
            }
            R.id.buttonClassicLikes -> {
                enumState = EnumState.CLassic
            }
        }
    }
}