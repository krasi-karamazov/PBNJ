package com.appsbg.navigation

import com.appsbg.navigation.coordinators.*
import com.appsbg.presentation.util.user.UserManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RootFlowCoordinator @Inject constructor(val userManager: UserManager) {

    lateinit var aboutFlowCoordinator: AboutFlowCoordinator
    lateinit var userDetailsFlowCorrdinator: UserDetailsFlowCorrdinator
    lateinit var casinoFlowCoordinator: CasinoFlowCoordinator
    lateinit var loginFlowCoordinator: LoginFlowCoordinator
    lateinit var newsFlowCoordinator: NewsFlowCoordinator
    lateinit var notificationsFlowCoordinator: NotificationsFlowCoordinator
    lateinit var settingsFlowCoordinator: SettingsFlowCoordinator
    lateinit var termsFlowCoordinator: TermsFlowCoordinator

    init {
        userManager.currentUser
    }
}