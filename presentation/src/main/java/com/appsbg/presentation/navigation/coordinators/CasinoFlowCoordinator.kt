package com.appsbg.presentation.navigation.coordinators

import com.appsbg.presentation.navigation.Navigator
import javax.inject.Inject

class CasinoFlowCoordinator @Inject constructor(val navigator: Navigator) {

    fun start(){
        navigator.showCasinosListActivity()
    }

    fun viewCasinoDetails(id: String) {
        TODO("view Casino details here")
    }
}