package com.notes.notes.utilits

import android.util.Log
import android.widget.Toast

fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_SHORT).show()
}

fun log(message: String) {
    Log.d("LOG", message)
}