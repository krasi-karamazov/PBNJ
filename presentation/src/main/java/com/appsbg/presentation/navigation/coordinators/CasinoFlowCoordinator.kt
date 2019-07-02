package com.appsbg.presentation.navigation.coordinators

import com.appsbg.model.poko.casinos.Casino
import com.appsbg.presentation.navigation.Navigator
import javax.inject.Inject

class CasinoFlowCoordinator @Inject constructor(val navigator: Navigator) {

    fun start(){
        navigator.showCasinosListActivity()
    }

    fun viewCasinoDetails(casino: Casino) {
        navigator.showCasinoDetailsActivity(casino)
    }
}