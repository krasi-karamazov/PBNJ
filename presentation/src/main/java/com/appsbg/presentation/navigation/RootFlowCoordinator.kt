package com.appsbg.navigation

import com.appsbg.navigation.coordinators.*
import javax.inject.Inject

class RootFlowCoordinator @Inject constructor(val aboutFlowCoordinator: AboutFlowCoordinator,
                                              val userDetailsFlowCorrdinator: UserDetailsFlowCorrdinator,
                                              val casinoFlowCoordinator: CasinoFlowCoordinator,
                                              val loginFlowCoordinator: LoginFlowCoordinator,
                                              val newsFlowCoordinator: NewsFlowCoordinator,
                                              val notificationsFlowCoordinator: NotificationsFlowCoordinator,
                                              val settingsFlowCoordinator: SettingsFlowCoordinator,
                                              val termsFlowCoordinator: TermsFlowCoordinator) {


}