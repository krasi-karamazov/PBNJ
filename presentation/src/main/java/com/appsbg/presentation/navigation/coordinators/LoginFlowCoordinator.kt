package com.appsbg.navigation.coordinators

import com.appsbg.navigation.Navigator
import javax.inject.Inject

class LoginFlowCoordinator @Inject constructor(val navigator: Navigator) {

    fun start(){
        navigator.showSplashScreen()
    }

    fun showWelcomeScreen() {

    }

    fun showLoginScreen(){

    }
}