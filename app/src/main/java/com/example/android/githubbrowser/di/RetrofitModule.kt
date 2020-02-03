package com.example.android.githubbrowser.di

import com.example.android.githubbrowser.GithubBrowserApp
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.repository.api.GithubApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        application: GithubBrowserApp,
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://${application.getString(R.string.git_hub_domain)}")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
}