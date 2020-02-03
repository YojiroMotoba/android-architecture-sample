package com.example.android.githubbrowser.di

import com.example.android.githubbrowser.repository.api.GithubApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideGithubApi(retrofit: Retrofit): GithubApi =
        retrofit.create(GithubApi::class.java)
}