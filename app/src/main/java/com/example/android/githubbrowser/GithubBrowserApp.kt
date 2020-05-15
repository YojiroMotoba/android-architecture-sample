package com.example.android.githubbrowser

import android.app.Application
import com.example.android.githubbrowser.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GithubBrowserApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GithubBrowserApp)
            modules(
                listOf(
                    retrofitModule,
                    repositoryModule,
                    interactorModule,
                    viewModelModule
                )
            )
        }
    }
}