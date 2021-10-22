package com.example.fontforinstagram.botton_navigation.button_ViewStickers

import androidx.fragment.app.Fragment

class PresenterStickers : IViewStickers.Presenter {
    var view : IViewStickers.View ? = null
    override fun onAttach(view: IViewStickers.View) {
        this.view = view
    }

    override fun switchFragment(ft: Fragment) {
        view!!.switchViewFragment(ft)
    }

    override fun clickItemRecycler(position: Int) {
        view!!.goToSelectedSticker(position)
    }
}