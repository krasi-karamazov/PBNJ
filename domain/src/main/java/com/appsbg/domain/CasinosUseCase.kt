package com.appsbg.domain

import com.appsbg.model.poko.casinos.Casino
import com.appsbg.model.repository.BaseRepository
import com.appsbg.model.repository.CasinosRepository
import io.reactivex.Single

class CasinosUseCase(val repo: CasinosRepository): BaseUsecase<List<Casino>>(repo) {
    override fun getData(): Single<List<Casino>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}