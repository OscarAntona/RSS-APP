package com.antgut.app.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showBar(text: String){
    Snackbar.make(
        this,
        text,
        Snackbar.LENGTH_SHORT
    ).show()
}