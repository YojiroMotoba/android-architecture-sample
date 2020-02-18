package com.example.android.githubbrowser.interactor

interface AuthInteractor {
    suspend fun getToken(): String
    suspend fun <T> requestWithToken(request: suspend (token: String) -> T): T
}
