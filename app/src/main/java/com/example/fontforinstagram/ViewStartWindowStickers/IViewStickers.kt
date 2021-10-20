package com.example.fontforinstagram.ViewStartWindowStickers

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