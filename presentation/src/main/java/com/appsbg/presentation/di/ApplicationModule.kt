package com.appsbg.presentation.di

import android.app.Application
import android.content.Context
import com.appsbg.presentation.utils.PermissionsHandler
import com.appsbg.presentation.utils.PermissionsHandlerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ApplicationModule {

    @Provides
    @Named("app_context")
    fun provideApplicationContext(application: Application): Context = application.applicationContext

    @Provides
    fun providePermissionsHandler() : PermissionsHandler = PermissionsHandlerImpl()

}