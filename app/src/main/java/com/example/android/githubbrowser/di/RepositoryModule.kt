package com.example.android.githubbrowser.di

import androidx.room.Room
import com.example.android.githubbrowser.GithubBrowserApp
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.db.GithubDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryModule = module {
    single { provideGithubDatabase(androidContext() as GithubBrowserApp) }
    single { provideGithubApi(get()) }
    single { get<GithubDatabase>().tokenDao() }
}

fun provideGithubDatabase(application: GithubBrowserApp): GithubDatabase =
    Room.databaseBuilder(application, GithubDatabase::class.java, "GithubDatabase")
        .allowMainThreadQueries()
        .build()

fun provideGithubApi(retrofit: Retrofit): GithubApi =
    retrofit.create(GithubApi::class.java)
