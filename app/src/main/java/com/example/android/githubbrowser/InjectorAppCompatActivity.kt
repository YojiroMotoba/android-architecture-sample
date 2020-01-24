package com.example.android.githubbrowser

import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


abstract class InjectorAppCompatActivity : AppCompatActivity, HasAndroidInjector {

    constructor()
    constructor(contentLayoutId: Int) : super(contentLayoutId)

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}