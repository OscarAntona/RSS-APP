package com.antgut.app.snackbar


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackbar(text: String) {
    Snackbar.make(requireView(),text,BaseTransientBottomBar.LENGTH_SHORT).show()
}
