package com.example.android.githubbrowser.interactor.impl

import android.util.Log
import com.example.android.githubbrowser.exception.SampleException
import com.example.android.githubbrowser.interactor.AuthInteractor
import com.example.android.githubbrowser.interactor.GithubInteractor
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.api.response.Repo
import javax.inject.Inject

class GithubInteractorImpl @Inject constructor(
    private val githubApi: GithubApi,
    private val authInteractor: AuthInteractor
) : GithubInteractor {

    override suspend fun searchRepos(query: String): List<Repo> {
        val token = authInteractor.getToken()
        Log.d("AAA", "token is $token")
        val res = githubApi.searchRepos(query)
        return res.items
    }

    override suspend fun exceptionSample() {
        throw SampleException("this is sample exception")
    }
}
