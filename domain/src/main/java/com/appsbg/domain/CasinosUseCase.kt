package com.appsbg.domain

import com.appsbg.model.poko.casinos.Casino
import com.appsbg.model.poko.casinos.CasinosWrapper
import com.appsbg.model.repository.CasinosRepository
import io.reactivex.Single

class CasinosUseCase(val repo: CasinosRepository): BaseUsecase<CasinosWrapper, List<Casino>>(repo) {
    override fun getData(): Single<List<Casino>> {
        return repo.getItems().flatMap { wrapper: CasinosWrapper -> Single.just(wrapper.casinos) }
    }
}