package com.example.fontforinstagram.ViewMovingText

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible


import android.view.inputmethod.InputMethodManager
import androidx.core.app.ActivityCompat.invalidateOptionsMenu
import androidx.core.view.GestureDetectorCompat
import com.dinuscxj.gesture.MultiTouchGestureDetector
import com.example.fontforinstagram.R
import com.example.fontforinstagram.Singleton
import android.view.MotionEvent
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.material.bottomnavigation.BottomNavigationView





class ViewMovingText : Fragment(), IContractMovingText.View, iState, View.OnClickListener{
    var editText : EditText? = null
    var imageViewFromTextView : ImageView? = null
    var textViewForEditCopy : TextView? = null

    private lateinit var mainConstr : ConstraintLayout
    private lateinit var textnull : TextView
    private lateinit var buttonEdiText : Button
    private lateinit var btnMozer : Button
    private var iStates : iState = this
    private lateinit var btnArthingon : Button
    private lateinit var btnExoLight : Button
    private lateinit var btnmazzardsoftm : Button
    private lateinit var btnRoboto : Button
    private var scrollViewFonts : HorizontalScrollView? = null
    private var presenter : PresenterMovingText? = null
    private var onTouch: MultiTouchGestureDetector? = null
    private var onDoubleTouch: GestureDetectorCompat? = null
    var flag = false
    set(value) {
        field = value
        if (flag == true) {
            presenter!!.onOffMultiTouch(false)
            Toast.makeText(context, "qwee", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ?????????? ?????? ???? ??????????????????
        var view:View = inflater.inflate(R.layout.view_moving_text, container, false)

        view.setOnTouchListener { v, event ->
                onTouch?.onTouchEvent(event);
               onDoubleTouch?.onTouchEvent(event)
                true
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        onTouch = MultiTouchGestureDetector(context, mMultiTouchGestureDetector(imageViewFromTextView!!))
        onDoubleTouch = GestureDetectorCompat(context, mDoubleTouch(imageViewFromTextView!!, this))

        presenter = PresenterMovingText()
        presenter?.view = this
        iStates = this

        btnArthingon.setOnClickListener(this)
        btnExoLight.setOnClickListener(this)
        btnmazzardsoftm.setOnClickListener(this)
        btnRoboto.setOnClickListener(this)
        btnMozer.setOnClickListener(this)



        // ?????????????????????? Edit Text ?? Image View
        val vto = editText!!.viewTreeObserver
        vto.addOnGlobalLayoutListener { editText!!.buildDrawingCache() }

//        buttonEdiText.setOnLongClickListener {
//            presenter!!.onOffMultiTouch(false)
//            return@setOnLongClickListener true
//        }

        buttonEdiText.setOnClickListener {

            presenter?.onOffMultiTouch(true)
        }
    }



    // ?????? ???????????????? ???????????????? ?? ?????????? ???????????? ?????? ?????????????? ?????????? ?????? ???????????????? ?????? ?? ?????????? imageView
//    fun ShaderForImageView(){
//        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.bbb)
//        val shader = BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
//        Singleton.textViewForEditCopy!!.paint.shader = shader
//    }

    // ?????????????????????? Edit Text ?? Image View
    fun convertToBitmanForImagage() : ImageView{
        Log.d("qweqw", "qwew")
        editText!!.buildDrawingCache()
        imageViewFromTextView!!.setImageBitmap(editText!!.drawingCache)

        return imageViewFromTextView!!
    }


    fun init(){
        scrollViewFonts = view?.findViewById(R.id.scrollViewFonts)
        btnArthingon = view?.findViewById(R.id.btnArthingon)!!
        btnExoLight = view?.findViewById(R.id.btnExoLight)!!
        btnmazzardsoftm = view?.findViewById(R.id.btnmazzardsoftm)!!
        btnRoboto = view?.findViewById(R.id.btnRoboto)!!
        btnMozer = view?.findViewById(R.id.btnMozer)!!
        mainConstr = view?.findViewById(R.id.mainConstr)!!
        buttonEdiText = view?.findViewById(R.id.buttonEdiText)!!
        textnull = view?.findViewById(R.id.textnull)!!
        editText = view?.findViewById(R.id.editText)!!
        imageViewFromTextView = view?.findViewById(R.id.imageViewFromTextView)!!
        textViewForEditCopy = view?.findViewById(R.id.textViewForEditCopy)!!
    }


    override fun onClick(v: View?) {

        when(v!!.id){
            R.id.btnMozer -> {
                presenter!!.switchFont(R.font.mozer, R.color.white)
                 }
            R.id.btnArthingon -> {
                presenter!!.switchFont(R.font.arthington, R.color.white)
            }
            R.id.btnExoLight -> {
                presenter!!.switchFont(R.font.exo_extralight, R.color.white)
            }

            R.id.btnRoboto -> {
                presenter!!.switchFont(R.font.roboto_medium, R.color.black)
            }
            R.id.btnmazzardsoftm -> {
                presenter!!.switchFont(R.font.mazzardsoftm, R.color.black)
            }

        }

    }

    override fun start() {
//        imageViewFromTextView!!.setOnTouchListener(requireContext())
        editText!!.visibility = View.INVISIBLE
        imageViewFromTextView!!.visibility = View.VISIBLE

    }

    override fun stop() {
        imageViewFromTextView!!.setOnTouchListener(null)
        editText!!.visibility = View.VISIBLE
        imageViewFromTextView!!.visibility = View.INVISIBLE

    }

    override fun applyFont(font: Int, color: Int) {
        var typeFace : Typeface? = ResourcesCompat.getFont(requireContext(), font)
        editText!!.setTypeface(typeFace)
        editText!!.setTextColor(ContextCompat.getColor(requireContext(), color))
        textViewForEditCopy!!.setTypeface(typeFace)
        textViewForEditCopy!!.setTextColor(ContextCompat.getColor(requireContext(), color))
    }


    override fun stateMultiTouch(boolean: Boolean) {
        when(boolean){
            true -> {
                if (view != null) {
                    val inputManager =
                        requireActivity().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    inputManager.hideSoftInputFromWindow(
                        requireView().windowToken,
                        InputMethodManager.HIDE_NOT_ALWAYS
                    )
                }

                scrollViewFonts!!.isVisible = false
                editText!!.isCursorVisible = false
                buttonEdiText.isVisible = false
                imageViewFromTextView!!.isVisible = true
                editText!!.setBackgroundColor(Color.TRANSPARENT);
                convertToBitmanForImagage()
//              imageViewFromTextView!!.setImageResource(R.drawable.clearpngg)
                iStates.start()
            }
            false -> {
                scrollViewFonts!!.isVisible = true
                editText!!.isCursorVisible = true
                imageViewFromTextView!!.isVisible = true
                buttonEdiText.isVisible = true
                editText!!.background = resources.getDrawable(R.drawable.shapeimage)
                val inp = requireActivity().getSystemService(
                    INPUT_METHOD_SERVICE
                ) as InputMethodManager
                inp.toggleSoftInputFromWindow(
                    editText!!.applicationWindowToken,
                    InputMethodManager.SHOW_IMPLICIT,
                    0
                )
                editText!!.requestFocus()
                iStates.stop()
            }
        }
    }




}