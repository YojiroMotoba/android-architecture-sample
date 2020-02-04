package com.example.android.githubbrowser.di

import androidx.room.Room
import com.example.android.githubbrowser.GithubBrowserApp
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.db.GithubDatabase
import com.example.android.githubbrowser.repository.db.dao.TokenDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideGithubDatabase(application: GithubBrowserApp): GithubDatabase =
        Room.databaseBuilder(application, GithubDatabase::class.java, "GithubDatabase")
            .allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun provideTokenDao(database: GithubDatabase): TokenDao = database.tokenDao()

    @Provides
    @Singleton
    fun provideGithubApi(retrofit: Retrofit): GithubApi = retrofit.create(GithubApi::class.java)
}