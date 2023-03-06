package com.dscoding.startingpoint.utils.extensions

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import com.dscoding.startingpoint.common.Constants.GOOGLE_PLAY_APP_URL
import com.dscoding.startingpoint.common.Constants.SOURCE_CODE_APP_URL

fun Context.openGooglePlayAppPage() {
    openUrl(GOOGLE_PLAY_APP_URL)
}

fun Context.openSourceCodePage() {
    openUrl(SOURCE_CODE_APP_URL)
}

fun Context.openUrl(url: String) {
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(browserIntent)
}

fun Context.launchShareAppIntent() {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(
            Intent.EXTRA_TEXT,
            "Check out this Github repository: $SOURCE_CODE_APP_URL"
        )
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    startActivity(shareIntent)
}

fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException("no activity")
}