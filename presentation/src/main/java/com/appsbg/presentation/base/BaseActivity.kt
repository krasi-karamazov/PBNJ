package com.appsbg.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.appsbg.presentation.factory.ViewModelFactory
import com.appsbg.presentation.navigation.Navigator
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity() {

    @Inject
    internal lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(getLayoutId())
    }

    override fun onStart() {
        super.onStart()
        navigator.activity = this
    }

    protected abstract fun getLayoutId(): Int

    inline fun <reified T: ViewModel> ViewModelFactory.get(): T = ViewModelProviders.of(this@BaseActivity, this)[T::class.java]
}