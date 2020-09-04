package com.example.android.githubbrowser.interactor.impl

import com.example.android.githubbrowser.exception.SampleException
import com.example.android.githubbrowser.interactor.AuthInteractor
import com.example.android.githubbrowser.interactor.GithubInteractor
import com.example.android.githubbrowser.logger
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.api.response.Repo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GithubInteractorImpl(
    private val githubApi: GithubApi,
    private val authInteractor: AuthInteractor
) : GithubInteractor {

    override suspend fun searchRepos(query: String): Flow<List<Repo>> = flow {
        authInteractor.requestWithToken {
            logger("start githubApi.searchRepos")
            val res = githubApi.searchRepos(query)
            emit(res.items)
        }
    }

    override suspend fun exceptionSample() {
        throw SampleException("this is sample exception")
    }
}
