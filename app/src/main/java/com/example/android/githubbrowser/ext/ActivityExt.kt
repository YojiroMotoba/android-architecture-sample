package com.example.android.githubbrowser.ext

import android.app.Activity
import android.widget.Toast
import com.example.android.githubbrowser.exception.SampleException

fun Activity.errorHandler(throwable: Throwable, callback: (Throwable) -> Unit = {}) {
    when (throwable) {
        is SampleException -> {
            Toast.makeText(this, "SampleExceptionが発生", Toast.LENGTH_LONG).show()
        }

        else -> callback.invoke(throwable)
    }
}