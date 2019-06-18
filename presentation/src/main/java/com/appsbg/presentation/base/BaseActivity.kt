package com.appsbg.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.appsbg.presentation.factory.ViewModelFactory
import com.appsbg.presentation.navigation.Navigator
import com.appsbg.presentation.navigation.RootFlowCoordinator
import com.appsbg.presentation.view.splash.SplashActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity() {

    @Inject
    internal lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(getLayoutId())
        navigator.activity = this
    }

    protected abstract fun getLayoutId(): Int

    inline fun <reified T: ViewModel> ViewModelFactory.get(): T = ViewModelProviders.of(this@BaseActivity, this)[T::class.java]

    override fun onDestroy() {
        navigator.activity = null
        super.onDestroy()
    }
}