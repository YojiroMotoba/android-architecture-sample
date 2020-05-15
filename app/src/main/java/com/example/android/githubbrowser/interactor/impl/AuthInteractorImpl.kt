package com.example.android.githubbrowser.interactor.impl

import android.util.Log
import com.example.android.githubbrowser.interactor.AuthInteractor
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.db.dao.TokenDao

class AuthInteractorImpl(
    val tokenDao: TokenDao,
    val githubApi: GithubApi
) : AuthInteractor {

    override suspend fun getToken(): String =
        tokenDao.select()?.accessToken ?: run {
            githubApi.searchRepos("test")
            Log.d("AAA", "accessToken is null")
            return "aaa"
        }

    override suspend fun <T> requestWithToken(request: suspend (token: String) -> T): T =
        request(tokenDao.select()!!.accessToken)
}
