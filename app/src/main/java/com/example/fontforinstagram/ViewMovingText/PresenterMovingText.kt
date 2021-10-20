package com.example.fontforinstagram.ViewMovingText

class PresenterMovingText: IContractMovingText.Presenter {
     var view : IContractMovingText.View? = null
    override fun onAttach(view: IContractMovingText.View) {
        this.view = view
    }

    override fun switchFont(font: Int, color: Int) {
        view!!.applyFont(font, color)
    }

    override fun onOffMultiTouch(boolean: Boolean) {
        view?.stateMultiTouch(boolean)
    }


}