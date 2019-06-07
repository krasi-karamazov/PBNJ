package com.appsbg.presentation.view.splash

import android.os.Bundle
import com.appsbg.navigation.coordinators.AboutFlowCoordinator
import com.appsbg.presentation.R
import com.appsbg.presentation.base.BaseActivity
import com.appsbg.presentation.factory.ViewModelFactory
import com.appsbg.presentation.viewmodel.splash.SplashViewModel
import javax.inject.Inject

class SplashActivity: BaseActivity() {

    @Inject
    internal lateinit var vmFactory:ViewModelFactory

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = vmFactory.get()
        AboutFlowCoordinator()
    }

    override fun getLayoutId(): Int = R.layout.activity_splash
}