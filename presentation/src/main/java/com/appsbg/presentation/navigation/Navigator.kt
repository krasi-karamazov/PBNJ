package com.appsbg.navigation

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.appsbg.presentation.view.splash.SplashActivity

class Navigator {

    val activity: FragmentActivity? = null

    fun showSplashScreen() {
        activity!!.startActivity(Intent(activity, SplashActivity::class.java))
    }

    fun showWelcomeScreen() {
        //activity!!.startActivity(Intent(activity, We::class.java))
    }

    fun showLoginScreen() {
        //activity!!.startActivity(Intent(activity, LoginActivity::class.java))
    }
}