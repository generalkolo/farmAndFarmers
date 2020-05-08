package com.example.cleanWithCoRoutine.common.utils

import android.content.Context
import android.content.Intent
import com.example.cleanWithCoRoutine.common.R

object AppActivityNavCommands {

    fun getStatisticsActivityIntent(context: Context) =
        navigationIntent(context, context.getString(R.string.statistics_home))

    private fun navigationIntent(context: Context, navAction: String) =
        Intent(navAction).setPackage(context.packageName)
}