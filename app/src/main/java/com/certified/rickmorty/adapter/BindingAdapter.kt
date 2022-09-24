package com.certified.rickmorty.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.certified.rickmorty.R

@BindingAdapter("visible")
fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("load_image")
fun ImageView.loadImage(url: String) {
    load(url) {
        placeholder(R.drawable.place_holder)
    }
}