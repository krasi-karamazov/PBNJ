package com.appsbg.model.repository

import com.appsbg.model.api.PalmsbetAPI
import com.appsbg.model.poko.casinos.CasinosWrapper
import dagger.Reusable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class CasinosRepository @Inject constructor(palmsbetAPI: PalmsbetAPI): BaseRepository<CasinosWrapper>(palmsbetAPI) {

    override fun getItems(): Single<CasinosWrapper> {
        return palmsBetApi.getCasinos()
    }
}