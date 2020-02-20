package com.example.android.githubbrowser.di

import com.example.android.githubbrowser.ui.SampleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeSampleFragment(): SampleFragment
}