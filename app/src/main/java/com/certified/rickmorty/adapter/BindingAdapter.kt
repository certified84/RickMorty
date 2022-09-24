package com.certified.rickmorty.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.certified.rickmorty.R
import java.text.SimpleDateFormat
import java.util.*

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

@BindingAdapter("parse_date")
fun TextView.parseDate(value: String) {

    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val date = formatter.parse(value)
        ?.let { SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(it) }
    val time = formatter.parse(value)
        ?.let { SimpleDateFormat("hh:mm a", Locale.getDefault()).format(it) }

    text = "$date $time"
}