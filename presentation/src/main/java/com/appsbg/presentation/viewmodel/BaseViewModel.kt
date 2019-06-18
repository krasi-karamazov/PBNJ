package com.appsbg.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.appsbg.presentation.navigation.RootFlowCoordinator
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModel(open var compositeDisposable: CompositeDisposable): ViewModel() {

    @Inject
    internal lateinit var rootFlowCoordinator: RootFlowCoordinator

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}