package com.appsbg.presentation.view.splash

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.appsbg.presentation.navigation.coordinators.AboutFlowCoordinator
import com.appsbg.presentation.R
import com.appsbg.presentation.base.BaseActivity
import com.appsbg.presentation.factory.ViewModelFactory
import com.appsbg.presentation.state.Resource
import com.appsbg.presentation.viewmodel.splash.SplashViewModel
import javax.inject.Inject

class SplashActivity: BaseActivity() {

    @Inject
    internal lateinit var vmFactory:ViewModelFactory

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = vmFactory.get()
        viewModel.preloadAllData().observe(this, Observer {
            when (it) {
                is Resource.Loading -> Log.d("LOADING", "LOADING")
                is Resource.Error -> Log.d("ERROR", it.message)
                else -> {
                    viewModel.displayWelcomeScreen()
                }
            }
        })
    }

    override fun getLayoutId(): Int = R.layout.activity_splash
}