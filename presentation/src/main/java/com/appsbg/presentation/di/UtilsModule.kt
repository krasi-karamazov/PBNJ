package com.appsbg.presentation.di

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class UtilsModule {

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable{
        return CompositeDisposable()
    }
}