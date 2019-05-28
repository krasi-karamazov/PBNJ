package com.appsbg.presentation.viewmodel.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appsbg.domain.GetStartupDataUseCase
import com.appsbg.model.poko.PalmsbetDataWrapper
import com.appsbg.presentation.state.Resource
import com.appsbg.presentation.viewmodel.extensions.reactToEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashViewModel @Inject constructor(val useCase: GetStartupDataUseCase, val compositeDisposable: CompositeDisposable): ViewModel() {
    private val data: MutableLiveData<Resource<PalmsbetDataWrapper>> = MutableLiveData()

    fun preloadAllData(): LiveData<Resource<PalmsbetDataWrapper>> {
        data.postValue(Resource.loading(null))
        compositeDisposable.add(useCase.getData(null)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnEvent{success, throwable -> reactToEvent(success, throwable)}
            .doOnSuccess { data.postValue(Resource.success(it)) }
            .subscribe())
        return data
    }


}