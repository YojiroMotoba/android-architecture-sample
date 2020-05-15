package com.example.android.githubbrowser.di

import com.example.android.githubbrowser.interactor.AuthInteractor
import com.example.android.githubbrowser.interactor.GithubInteractor
import com.example.android.githubbrowser.interactor.impl.AuthInteractorImpl
import com.example.android.githubbrowser.interactor.impl.GithubInteractorImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val interactorModule: Module = module {
    single<GithubInteractor> { GithubInteractorImpl(get(), get()) }
    single<AuthInteractor> { AuthInteractorImpl(get(), get()) }
}
