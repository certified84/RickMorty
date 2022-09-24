package com.certified.rickmorty.ui.custom

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.Window
import androidx.appcompat.app.AlertDialog

class CustomDialog @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : AlertDialog(context, defStyle) {
    override fun getWindow(): Window? {
        val window = super.getWindow()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return window
    }
}