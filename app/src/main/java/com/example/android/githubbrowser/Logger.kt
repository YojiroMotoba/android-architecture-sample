package com.example.android.githubbrowser

fun logger(msg: String) = println("${Thread.currentThread().name} : $msg")