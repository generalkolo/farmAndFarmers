package com.example.cleanWithCoRoutine.statistics.utils

import android.graphics.Bitmap
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.cleanWithCoRoutine.statistics.R

@BindingAdapter("farmerImage")
fun farmerImageResource(imageView: ImageView, farmerBitMap: Bitmap) {
    Glide.with(imageView.context)
        .load(farmerBitMap)
        .fitCenter()
        .into(imageView)
}

@BindingAdapter(value = ["firstName", "lastName"], requireAll = true)
fun TextView.setFarmersFullName(firstName: String, lastName: String) {
    this.text = this.context.resources.getString(R.string.first_last_name, firstName, lastName)
}

object Helpers {
    @JvmStatic
    fun setFarmersFullName(firstName: String, lastName: String): String {
        return "$firstName $lastName"
    }
}