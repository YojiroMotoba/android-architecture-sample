package com.example.android.githubbrowser

import com.example.android.githubbrowser.di.ActivityModule
import com.example.android.githubbrowser.di.RetrofitModule
import com.example.android.githubbrowser.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        RetrofitModule::class]
)
interface AppComponent : AndroidInjector<GithubBrowserApp> {

    override fun inject(application: GithubBrowserApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: GithubBrowserApp
        ): AppComponent
    }
}