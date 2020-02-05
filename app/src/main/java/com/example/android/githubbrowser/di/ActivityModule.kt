package com.example.android.githubbrowser.di

import com.example.android.githubbrowser.MainActivity
import com.example.android.githubbrowser.ui.DebugActivity
import com.example.android.githubbrowser.ui.DetailSampleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeDebugActivity(): DebugActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailSampleActivity(): DetailSampleActivity
}