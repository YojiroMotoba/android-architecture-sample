package com.example.android.githubbrowser.interactor

interface AuthInteractor {
    suspend fun getToken(): String
}
