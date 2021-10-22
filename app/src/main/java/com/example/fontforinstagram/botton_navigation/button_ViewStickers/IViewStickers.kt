package com.example.fontforinstagram.botton_navigation.button_ViewStickers

import androidx.fragment.app.Fragment

interface IViewStickers {

    interface Presenter{

        fun onAttach(view : View)

        fun switchFragment(ft : Fragment)

        fun clickItemRecycler(position : Int)
    }

    interface View {

        fun switchViewFragment(ft : Fragment)

        fun goToSelectedSticker(position: Int)

    }
}