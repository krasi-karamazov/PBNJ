package com.appsbg.presentation.viewmodel.casinos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appsbg.domain.CasinosUseCase
import com.appsbg.model.poko.PalmsbetDataWrapper
import com.appsbg.model.poko.casinos.Casino
import com.appsbg.model.poko.casinos.CasinosWrapper
import com.appsbg.presentation.state.Resource
import com.appsbg.presentation.viewmodel.BaseViewModel
import com.appsbg.presentation.viewmodel.extensions.getAppropriateEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CasinosListViewModel @Inject constructor(val useCase: CasinosUseCase, override var compositeDisposable: CompositeDisposable): BaseViewModel(compositeDisposable) {
    private val data: MutableLiveData<Resource<List<Casino>>> = MutableLiveData()

    fun getCasinos(): LiveData<Resource<List<Casino>>> {
        data.postValue(Resource.loading(null))
        compositeDisposable.add(useCase.getData(null)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnEvent{success, throwable -> data.postValue(getAppropriateEvent(success, throwable))}
            .subscribe())
        return data
    }

    fun openCasinoDetails(casinoId: String) {
        rootFlowCoordinator.casinoFlowCoordinator.viewCasinoDetails(casinoId)
    }
}