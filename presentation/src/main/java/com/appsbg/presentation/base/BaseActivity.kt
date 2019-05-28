package com.appsbg.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.appsbg.presentation.factory.ViewModelFactory
import dagger.android.AndroidInjection

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(getLayoutId())
    }

    protected abstract fun getLayoutId(): Int

    inline fun <reified T: ViewModel> ViewModelFactory.get(): T = ViewModelProviders.of(this@BaseActivity, this)[T::class.java]
}