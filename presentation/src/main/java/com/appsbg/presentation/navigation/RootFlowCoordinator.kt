package com.appsbg.presentation.navigation

import com.appsbg.presentation.navigation.coordinators.*
import com.appsbg.presentation.util.user.UserManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RootFlowCoordinator @Inject constructor(val userManager: UserManager,
                                              val aboutFlowCoordinator: AboutFlowCoordinator,
                                              val userDetailsFlowCoordinator: UserDetailsFlowCoordinator,
                                              val casinoFlowCoordinator: CasinoFlowCoordinator,
                                              val loginFlowCoordinator: LoginFlowCoordinator,
                                              val newsFlowCoordinator: NewsFlowCoordinator,
                                              val notificationsFlowCoordinator: NotificationsFlowCoordinator,
                                              val settingsFlowCoordinator: SettingsFlowCoordinator,
                                              val termsFlowCoordinator: TermsFlowCoordinator) {
    fun start() {
        loginFlowCoordinator.start()
    }
}