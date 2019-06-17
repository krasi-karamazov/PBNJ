package com.appsbg.navigation

import com.appsbg.navigation.coordinators.*
import com.appsbg.presentation.util.user.AuthenticatedUser
import com.appsbg.presentation.util.user.NotAuthenticated
import com.appsbg.presentation.util.user.UserManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RootFlowCoordinator @Inject constructor(val userManager: UserManager) {

    @Inject
    internal lateinit var aboutFlowCoordinator: AboutFlowCoordinator

    @Inject
    internal lateinit var userDetailsFlowCorrdinator: UserDetailsFlowCorrdinator

    @Inject
    internal lateinit var casinoFlowCoordinator: CasinoFlowCoordinator

    @Inject
    internal lateinit var loginFlowCoordinator: LoginFlowCoordinator

    @Inject
    internal lateinit var newsFlowCoordinator: NewsFlowCoordinator

    @Inject
    internal lateinit var notificationsFlowCoordinator: NotificationsFlowCoordinator

    @Inject
    internal lateinit var settingsFlowCoordinator: SettingsFlowCoordinator

    @Inject
    internal lateinit var termsFlowCoordinator: TermsFlowCoordinator

    init {
        loginFlowCoordinator.start()
    }
}