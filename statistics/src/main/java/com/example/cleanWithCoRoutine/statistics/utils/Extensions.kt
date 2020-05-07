package com.example.cleanWithCoRoutine.statistics.utils

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs


@SuppressLint("SimpleDateFormat")
fun Date.dateToStringWithPattern(pattern: String): String = SimpleDateFormat(pattern).format(this)

fun Fragment.showToast(message: String) {
    Toast.makeText(this.requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Fragment.displayImageUsingGlide(bitmap: Bitmap, view: ImageView) {
    Glide.with(this.requireContext())
        .load(bitmap)
        .fitCenter()
        .into(view)
}

private fun LocalDateTime.toMillis(zone: ZoneId = ZoneId.systemDefault()) =
    atZone(zone)?.toInstant()?.toEpochMilli()

fun Long.differenceInYears(olderLong: Long? = LocalDateTime.now().toMillis()): String {
    val currentYear = convertLongToTime(olderLong!!)
    val choosenYear = convertLongToTime(this)

    val diffInMillies: Long = abs(currentYear.time - choosenYear.time)
    val diff: Long = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)
    return (diff / 365).toString()
}

private fun convertLongToTime(time: Long): Date {
    return Date(time)
}