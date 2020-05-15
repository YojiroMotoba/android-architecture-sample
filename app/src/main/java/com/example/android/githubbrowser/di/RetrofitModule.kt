package com.example.android.githubbrowser.di

import com.example.android.githubbrowser.GithubBrowserApp
import com.example.android.githubbrowser.R
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val retrofitModule = module {
    single { provideMoshi() }
    single { provideOkHttp() }
    single { provideRetrofit(androidContext() as GithubBrowserApp, get(), get()) }
}

fun provideMoshi(): Moshi =
    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

fun provideOkHttp(): OkHttpClient =
    OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .build()

fun provideRetrofit(
    application: GithubBrowserApp,
    okHttpClient: OkHttpClient,
    moshi: Moshi
): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://${application.getString(R.string.git_hub_domain)}")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
