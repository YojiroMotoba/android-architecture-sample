package com.example.android.githubbrowser.di

import com.example.android.githubbrowser.GithubBrowserApp
import com.example.android.githubbrowser.MainViewModel
import com.example.android.githubbrowser.ui.viewmodel.DebugViewModel
import com.example.android.githubbrowser.ui.viewmodel.DetailSampleViewModel
import com.example.android.githubbrowser.ui.viewmodel.RoomSampleViewModel
import com.example.android.githubbrowser.ui.viewmodel.SampleFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
    viewModel { DebugViewModel(androidContext() as GithubBrowserApp) }
    viewModel { DetailSampleViewModel(get()) }
    viewModel { SampleFragmentViewModel(get()) }
    viewModel { RoomSampleViewModel(get()) }
}
