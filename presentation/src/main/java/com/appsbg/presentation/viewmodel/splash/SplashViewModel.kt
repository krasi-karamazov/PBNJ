package com.appsbg.presentation.viewmodel.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appsbg.domain.GetStartupDataUseCase
import com.appsbg.model.poko.PalmsbetDataWrapper
import com.appsbg.presentation.state.Resource
import com.appsbg.presentation.viewmodel.BaseViewModel
import com.appsbg.presentation.viewmodel.extensions.getAppropriateEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashViewModel @Inject constructor(val useCase: GetStartupDataUseCase, override var compositeDisposable: CompositeDisposable): BaseViewModel(compositeDisposable) {
    private val data: MutableLiveData<Resource<PalmsbetDataWrapper>> = MutableLiveData()

    fun preloadAllData(): LiveData<Resource<PalmsbetDataWrapper>> {
        data.postValue(Resource.loading(null))
        compositeDisposable.add(useCase.getData(null)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnEvent{success, throwable -> data.postValue(getAppropriateEvent(success, throwable))}
            .subscribe())
        return data
    }

    fun displayWelcomeScreen() {
        rootFlowCoordinator.loginFlowCoordinator.showWelcomeScreen()
    }

}