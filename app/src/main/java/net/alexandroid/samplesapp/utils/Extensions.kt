package net.alexandroid.samplesapp.utils

import android.view.View

fun View.OnClickListener.listenForClicks(vararg views: View) {
    views.forEach { it.setOnClickListener(this) }
}