package com.appsbg.presentation.di

import android.accounts.AccountManager
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AccountModule {

    @Provides
    fun provideAccountManager(@Named("app_context") context: Context): AccountManager = context.getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
}