package com.certified.rickmorty.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import com.certified.rickmorty.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*


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

    @SuppressLint("ClickableViewAccessibility")
    fun View.hold(click: () -> Unit, longClick: () -> Unit) {

        val longClickDuration = 3000L
        var isLongPress = true
        var coroutineScope: CoroutineScope? = null
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager =
                context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else
            @Suppress("DEPRECATION")
            context.getSystemService(VIBRATOR_SERVICE) as Vibrator

        setOnTouchListener { _, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {

                    if (Build.VERSION.SDK_INT >= 26)
                        vibrator.vibrate(VibrationEffect.createOneShot(longClickDuration, 10));
                    else
                        @Suppress("DEPRECATION") vibrator.vibrate(longClickDuration)

                    coroutineScope = CoroutineScope(Dispatchers.Main)
                    coroutineScope?.launch {
                        delay(longClickDuration); longClick(); isLongPress = false
                    }

                    true
                }
                MotionEvent.ACTION_UP -> {
                    isLongPress = false
                    vibrator.cancel()
                    coroutineScope?.cancel()
                    click()
                    true
                }
                else -> {
                    isLongPress = false
                    coroutineScope?.cancel()
                    coroutineScope = null
                    false
                }
            }
        }
    }

    fun View.showSnackBar(message: String, action: (() -> Unit)?) =
        Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE)
            .setAction("Dismiss") {
                if (action != null) {
                    action()
                }
            }.show()
}