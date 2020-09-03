package com.example.android.githubbrowser.interactor

import com.example.android.githubbrowser.repository.api.response.Repo
import kotlinx.coroutines.flow.Flow

interface GithubInteractor {
    suspend fun searchRepos(query: String): Flow<List<Repo>>
    suspend fun exceptionSample()
}
