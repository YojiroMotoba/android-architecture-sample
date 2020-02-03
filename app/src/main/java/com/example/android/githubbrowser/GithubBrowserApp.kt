package com.example.android.githubbrowser

import android.app.Application
import com.example.android.githubbrowser.di.applyInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class GithubBrowserApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        DaggerAppComponent.factory().create(this).inject(this)
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        applyInjector()
    }
}