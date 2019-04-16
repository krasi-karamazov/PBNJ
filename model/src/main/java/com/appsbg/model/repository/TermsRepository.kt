package com.appsbg.model.repository

import com.appsbg.model.api.PalmsbetAPI
import com.appsbg.model.cache.SharedPreferencesCache
import com.appsbg.model.poko.terms.Terms
import io.reactivex.Single
import javax.inject.Inject

class TermsRepository @Inject constructor(palmsbetAPI: PalmsbetAPI): BaseRepository<Terms>(palmsbetAPI) {

    @Inject
    internal lateinit var sharedPreferencesCache: SharedPreferencesCache

    override fun getItems(): Single<Terms> {
        return palmsBetApi.getTerms(username = sharedPreferencesCache.getData(SharedPreferencesCache.USERNAME_KEY)!!)
    }
}