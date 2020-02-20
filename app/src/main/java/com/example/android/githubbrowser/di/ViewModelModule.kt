package com.example.android.githubbrowser.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.githubbrowser.MainViewModel
import com.example.android.githubbrowser.ui.viewmodel.DebugViewModel
import com.example.android.githubbrowser.ui.viewmodel.DetailSampleViewModel
import com.example.android.githubbrowser.ui.viewmodel.SampleFragmentViewModel
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
    @IntoMap
    @ViewModelKey(DetailSampleViewModel::class)
    abstract fun bindDetailSampleViewModel(detailSampleViewModel: DetailSampleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SampleFragmentViewModel::class)
    abstract fun bindSampleFragmentViewModel(sampleFragmentViewModel: SampleFragmentViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
