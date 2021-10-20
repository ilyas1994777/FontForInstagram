package com.example.fontforinstagram.ViewMovingText

interface IContractMovingText {

    interface Presenter {
        fun onAttach(view : View)
        fun switchFont(font: Int, color : Int)
        fun onOffMultiTouch(boolean: Boolean)

    }

    interface View {
        fun applyFont(font: Int, color : Int)
        fun stateMultiTouch(boolean: Boolean)
    }
}