package com.example.android.githubbrowser

import android.app.Application
import com.example.android.githubbrowser.di.interactorModule
import com.example.android.githubbrowser.di.repositoryModule
import com.example.android.githubbrowser.di.retrofitModule
import com.example.android.githubbrowser.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GithubBrowserApp : Application() {

    private val diModules = listOf(
        retrofitModule,
        repositoryModule,
        interactorModule,
        viewModelModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GithubBrowserApp)
            modules(diModules)
        }
    }
}