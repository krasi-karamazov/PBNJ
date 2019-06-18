package com.appsbg.presentation.navigation

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.appsbg.presentation.view.casinos.CasinosListActivity
import com.appsbg.presentation.view.splash.SplashActivity
import com.appsbg.presentation.view.welcome.WelcomeActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor() {

    var activity: FragmentActivity? = null

    fun showSplashScreen() {
        activity!!.startActivity(Intent(activity, SplashActivity::class.java))
    }

    fun showWelcomeScreen() {
        activity!!.startActivity(Intent(activity, WelcomeActivity::class.java))
    }

    fun showLoginScreen() {
        //activity!!.startActivity(Intent(activity, LoginActivity::class.java))
    }

    fun showCasinosListActivity() {
        activity!!.startActivity(Intent(activity, CasinosListActivity::class.java))
    }
}