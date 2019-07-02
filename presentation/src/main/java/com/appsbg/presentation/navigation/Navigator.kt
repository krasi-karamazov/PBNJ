package com.appsbg.presentation.navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.appsbg.model.poko.casinos.Casino
import com.appsbg.presentation.view.casinodetails.CasinoDetailsActivity
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
        closeCurrentActivity()
        activity!!.startActivity(Intent(activity, WelcomeActivity::class.java))
    }

    fun showLoginScreen() {
        closeCurrentActivity()
        //activity!!.startActivity(Intent(activity, LoginActivity::class.java))
    }

    fun showCasinosListActivity() {
        closeCurrentActivity()
        activity!!.startActivity(Intent(activity, CasinosListActivity::class.java))
    }

    fun showCasinoDetailsActivity(casino: Casino) {
        val casinoDetailsIntent = Intent(activity, CasinoDetailsActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable(CasinoDetailsActivity.CASINO_EXTRAS_KEY, casino)
        activity!!.startActivity(casinoDetailsIntent)
    }

    fun closeCurrentActivity() {
        activity!!.finish()
    }
}