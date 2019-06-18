package com.appsbg.presentation.di

import com.appsbg.presentation.view.casinos.CasinosListActivity
import com.appsbg.presentation.view.splash.SplashActivity
import com.appsbg.presentation.view.welcome.WelcomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun bindWelcomeActivity(): WelcomeActivity

    @ContributesAndroidInjector
    abstract fun bindCasinosListActivity(): CasinosListActivity
}