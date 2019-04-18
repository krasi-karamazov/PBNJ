package com.appsbg.model.repository

import com.appsbg.model.api.PalmsbetAPI
import io.reactivex.Single
import javax.inject.Inject

class LoginRepository @Inject constructor(private var palmsbetAPI: PalmsbetAPI) : BaseRepository<String>(palmsbetAPI) {
    override fun getItems(): Single<String> {
        palmsbetAPI.getSession()
    }

}