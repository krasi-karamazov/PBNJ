package com.appsbg.domain

import com.appsbg.model.poko.PalmsbetDataWrapper
import com.appsbg.model.repository.StartupDataRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetStartupDataUseCase @Inject constructor(val repo: StartupDataRepository): BaseUsecase<PalmsbetDataWrapper, PalmsbetDataWrapper>(repo) {
    override fun getData(args: Map<String, Any>?): Single<PalmsbetDataWrapper>{
        return repo.getItems(args)
            .subscribeOn(Schedulers.io())
    }

}