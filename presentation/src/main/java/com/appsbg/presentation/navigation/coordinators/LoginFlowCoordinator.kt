package com.appsbg.presentation.navigation.coordinators

import com.appsbg.presentation.navigation.Navigator
import javax.inject.Inject

class LoginFlowCoordinator @Inject constructor(val navigator: Navigator) {

    fun start(){
        navigator.showSplashScreen()
    }

    fun showWelcomeScreen() {
        navigator.showWelcomeScreen()
    }

    fun showLoginScreen(){

    }
}