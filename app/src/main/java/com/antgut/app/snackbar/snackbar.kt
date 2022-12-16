package com.antgut.app.snackbar


import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackbar(text: String, viewGroup: ViewGroup) {
    Snackbar.make(
        viewGroup,
        text,
        BaseTransientBottomBar.LENGTH_SHORT
    ).show()
}
