package com.appsbg.presentation.view.welcome

import android.os.Bundle
import com.appsbg.presentation.R
import com.appsbg.presentation.base.BaseActivity
import com.appsbg.presentation.factory.ViewModelFactory
import com.appsbg.presentation.viewmodel.welcome.WelcomeViewModel
import kotlinx.android.synthetic.main.content_welcome.*
import javax.inject.Inject

class WelcomeActivity: BaseActivity() {

    @Inject
    internal lateinit var vmFactory: ViewModelFactory

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = vmFactory.get()
        initView()
    }

    private fun initView() {
        btn_skip.setOnClickListener{viewModel.onSkip()}
        btn_login.setOnClickListener{viewModel.onLogin()}
    }

    override fun getLayoutId(): Int = R.layout.activity_welcome
}