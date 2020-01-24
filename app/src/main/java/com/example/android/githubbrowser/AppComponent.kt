package com.example.android.githubbrowser

import com.example.android.githubbrowser.di.ActivityModule
import com.example.android.githubbrowser.di.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        RetrofitModule::class]
)
interface AppComponent : AndroidInjector<GithubBrowserApp> {

    override fun inject(application: GithubBrowserApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: GithubBrowserApp): Builder

        fun build(): AppComponent
    }
}