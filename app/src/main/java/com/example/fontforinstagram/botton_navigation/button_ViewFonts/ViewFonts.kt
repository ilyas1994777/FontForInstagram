package com.example.fontforinstagram.botton_navigation.button_ViewFonts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.fontforinstagram.R
import com.example.fontforinstagram.botton_navigation.button_ViewFonts.switchFonts.ViewColorFul.ViewColorFul
import com.example.fontforinstagram.botton_navigation.button_ViewFonts.switchFonts.viewClassic.ViewClassic


class ViewFonts : Fragment() {

    private var buttonColorFull : Button? = null
    private var buttonClassic : Button? = null
    private var flagStateSwitchButton = false
    set(value) {
        field = value
        when(flagStateSwitchButton){
            false -> {
                buttonColorFull!!.setTextColor(resources.getColor(R.color.orange))
                buttonColorFull!!.background = resources.getDrawable(R.drawable.back_buttons_fonts_classic)

                buttonClassic!!.background = resources.getDrawable(R.drawable.back_buttons_fons_classic_disable)
                buttonClassic!!.setTextColor(resources.getColor(R.color.white))
            }
            true -> {
                buttonClassic!!.setTextColor(resources.getColor(R.color.orange))
                buttonClassic!!.background = resources.getDrawable(R.drawable.back_buttons_fonts_classic)

                buttonColorFull!!.background = resources.getDrawable(R.drawable.back_buttons_fons_classic_disable)
                buttonColorFull!!.setTextColor(resources.getColor(R.color.white))
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
        return inflater.inflate(R.layout.view_fonts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonColorFull = view.findViewById(R.id.buttonColorFull)
        buttonClassic = view.findViewById(R.id.buttonClassic)





        buttonClassic!!.setOnClickListener {
            flagStateSwitchButton = true
          switchFragmentFonts(ViewClassic())
        }

        buttonColorFull!!.setOnClickListener {
            flagStateSwitchButton = false
            switchFragmentFonts(ViewColorFul())
        }




    }

    fun switchFragmentFonts(ft : Fragment){
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragg, ft)
            commit()
        }
    }



}