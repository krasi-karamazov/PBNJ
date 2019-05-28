package com.appsbg.model.repository

import com.appsbg.model.api.PalmsbetAPI
import com.appsbg.model.poko.PalmsbetDataWrapper
import io.reactivex.Single
import javax.inject.Inject

class StartupDataRepository @Inject constructor(palmsbetAPI: PalmsbetAPI): BaseRepository<PalmsbetDataWrapper>(palmsbetAPI) {
    override fun getItems(args: Map<String, Any>?): Single<PalmsbetDataWrapper> = palmsBetApi.getAll()
}