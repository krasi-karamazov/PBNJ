package com.appsbg.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appsbg.presentation.factory.ViewModelFactory
import com.appsbg.presentation.viewmodel.casinodetails.CasinoDetailsViewModel
import com.appsbg.presentation.viewmodel.casinos.CasinosListViewModel
import com.appsbg.presentation.viewmodel.splash.SplashViewModel
import com.appsbg.presentation.viewmodel.welcome.WelcomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel::class)
    internal abstract fun bindWelcomeViewModel(viewModel: WelcomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CasinosListViewModel::class)
    internal abstract fun bindCasinosListViewModel(viewModel: CasinosListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CasinoDetailsViewModel::class)
    internal abstract fun bindCasinoDetailsViewModel(viewModel: CasinoDetailsViewModel): ViewModel

    //Add more ViewModels here
}