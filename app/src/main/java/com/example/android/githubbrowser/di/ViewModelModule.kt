package com.example.android.githubbrowser.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.githubbrowser.MainViewModel
import com.example.android.githubbrowser.ui.viewmodel.DebugViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import net.zexy.enmusubi.di.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindSearchViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DebugViewModel::class)
    abstract fun bindDebugViewModel(debugViewModel: DebugViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
