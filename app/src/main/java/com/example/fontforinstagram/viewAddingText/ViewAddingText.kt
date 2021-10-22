package com.example.fontforinstagram.viewAddingText

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import com.example.fontforinstagram.R
import com.example.fontforinstagram.Singleton
import com.example.fontforinstagram.ViewMovingText.AddTextTap
import com.example.fontforinstagram.ViewMovingText.ViewMovingText



class ViewAddingText : Fragment() {

    private var editPasterOrWriteText : EditText? = null

    private var onDoubleTouchh: GestureDetectorCompat? = null


    var sendTextForViewMovingText = false
    set(value) {
        field = value
        if (sendTextForViewMovingText == true){
                if (editPasterOrWriteText?.text!!.isNotEmpty()){
                    val bundle = Bundle()
                    bundle.putString("key", editPasterOrWriteText!!.text.toString())
                    val movingText = ViewMovingText()
                    movingText.arguments = bundle
                    Singleton.switchFragment(movingText)
                } else Toast.makeText(context, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.view_adding_text, container, false)
        var view : View = inflater.inflate(R.layout.view_adding_text, container, false)

        view.setOnTouchListener { v, event ->
            onDoubleTouchh?.onTouchEvent(event)
            true
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        onDoubleTouchh = GestureDetectorCompat(context, AddTextTap(this))

            if (arguments != null) {
                val getTextt = arguments?.getString("keys")

                editPasterOrWriteText!!.setText(getTextt)

            }


    }

    fun init(){
        editPasterOrWriteText = view?.findViewById(R.id.editPasterOrWriteText)!!
    }
}