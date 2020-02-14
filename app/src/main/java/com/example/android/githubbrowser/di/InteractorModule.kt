package com.example.android.githubbrowser.di

import com.example.android.githubbrowser.interactor.AuthInteractor
import com.example.android.githubbrowser.interactor.GithubInteractor
import com.example.android.githubbrowser.interactor.impl.AuthInteractorImpl
import com.example.android.githubbrowser.interactor.impl.GithubInteractorImpl
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.db.dao.TokenDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Singleton
    @Provides
    fun provideGithubInteractor(
        githubApi: GithubApi,
        authInteractor: AuthInteractor
    ): GithubInteractor = GithubInteractorImpl(githubApi, authInteractor)


    @Singleton
    @Provides
    fun provideAuthInteractor(tokenDao: TokenDao, githubApi: GithubApi): AuthInteractor =
        AuthInteractorImpl(tokenDao, githubApi)
}