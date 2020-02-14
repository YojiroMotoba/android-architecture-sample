package com.example.android.githubbrowser.interactor.impl

import android.util.Log
import com.example.android.githubbrowser.interactor.AuthInteractor
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.db.dao.TokenDao
import javax.inject.Inject

class AuthInteractorImpl @Inject constructor(
    private val tokenDao: TokenDao,
    private val githubApi: GithubApi
) : AuthInteractor {

    override suspend fun getToken(): String {
        val token = tokenDao.select()
        if (token == null) {
            val res = githubApi.searchRepos("test")
            Log.d("AAA", "")
            return "aaa"
        }
        return token.accessToken
    }
}
