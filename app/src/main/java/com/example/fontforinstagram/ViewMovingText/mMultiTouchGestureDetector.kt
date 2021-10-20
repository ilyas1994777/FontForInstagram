package com.example.fontforinstagram.ViewMovingText

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.Toast
import com.dinuscxj.gesture.MultiTouchGestureDetector
import com.example.fontforinstagram.Singleton

 class mDoubleTouch(val imageView: ImageView, val nn: ViewMovingText):GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {


    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {

        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
//        viewMovingText.flag = true

        nn.flag = true

//        Toast.makeText(Singleton.mainActivity, "Double Tap", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
//        Log.d("qweqwe","double Tap dragon")
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onShowPress(e: MotionEvent?) {

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return true
    }

    override fun onLongPress(e: MotionEvent?) {

    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        return true
    }


}
class mMultiTouchGestureDetector(val imageView: ImageView) : MultiTouchGestureDetector.OnMultiTouchGestureListener

{
    var mScaleFactor: Float = 0f;
    var mRotation: Float = 0f;


    override fun onScale(detector: MultiTouchGestureDetector?) {
        mScaleFactor *= detector!!.scale;
        mScaleFactor = Math.max(1.0f, Math.min(mScaleFactor, 5.0f))

        imageView?.scaleX = mScaleFactor
        imageView?.scaleY = mScaleFactor

        Singleton.mainActivity!!.invalidateOptionsMenu()
    }

    override fun onMove(detector: MultiTouchGestureDetector?) {
        // движение по экрану
        // if ( ширина экрана < imageView!!.x){
        imageView!!.x += detector!!.moveX
        imageView!!.y += detector!!.moveY
        //}

        // if ( высотка экрана < imageView!!.y){
//        imageView!!.x += detector!!.moveX
//        imageView!!.y += detector!!.moveY
        //}
    }

    override fun onRotate(detector: MultiTouchGestureDetector?) {
        mRotation += detector!!.rotation;

        imageView?.rotation = mRotation
        Singleton.mainActivity!!.invalidateOptionsMenu()
    }

    override fun onBegin(detector: MultiTouchGestureDetector?): Boolean {

        return true
    }

    override fun onEnd(detector: MultiTouchGestureDetector?) {
    }




}