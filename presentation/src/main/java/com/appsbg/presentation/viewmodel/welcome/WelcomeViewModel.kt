package com.appsbg.presentation.viewmodel.welcome

import androidx.lifecycle.ViewModel
import com.appsbg.presentation.viewmodel.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class WelcomeViewModel @Inject constructor(override var compositeDisposable: CompositeDisposable) : BaseViewModel(compositeDisposable) {
    fun onSkip() {
        rootFlowCoordinator.casinoFlowCoordinator.start()
    }

    fun onLogin() {
        rootFlowCoordinator.loginFlowCoordinator.showLoginScreen()
    }
}