package com.certified.rickmorty.util

import android.view.View
import android.view.animation.AnimationUtils
import com.certified.rickmorty.R

object Extensions {

    fun View.zoomIn() {
        val zoomIn = AnimationUtils.loadAnimation(context, R.anim.zoom_in)
        this.apply {
            visibility = View.VISIBLE
            startAnimation(zoomIn)
        }
    }

    fun View.zoomOut() {
        val zoomOut = AnimationUtils.loadAnimation(context, R.anim.zoom_out)
        this.apply {
            visibility = View.GONE
            startAnimation(zoomOut)
        }
    }
}