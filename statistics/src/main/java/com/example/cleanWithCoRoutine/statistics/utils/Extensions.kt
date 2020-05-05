package com.example.cleanWithCoRoutine.statistics.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
fun Date.dateToStringWithPattern(pattern: String): String = SimpleDateFormat(pattern).format(this)