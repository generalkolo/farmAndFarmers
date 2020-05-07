package com.example.cleanWithCoRoutine.statistics.utils

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("farmerImage")
fun farmerImageResource(imageView: ImageView, farmerBitMap: Bitmap) {
    Glide.with(imageView.context)
        .load(farmerBitMap)
        .fitCenter()
        .into(imageView)
}