package com.appsbg.palmsbetapp.di

import android.app.Application
import com.appsbg.model.di.NetworkingModule
import com.appsbg.palmsbetapp.application.PalmsbetApplication
import com.appsbg.presentation.di.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityBuilder::class, NetworkingModule::class, UtilsModule::class, ViewModelModule::class, ApplicationModule::class, AccountModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application:Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(application: PalmsbetApplication)

}