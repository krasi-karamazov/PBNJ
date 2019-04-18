package com.appsbg.model.repository

import com.appsbg.model.api.PalmsbetAPI
import com.appsbg.model.cache.SharedPreferencesCache
import com.appsbg.model.poko.about.About
import dagger.Reusable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class AboutRepository @Inject constructor(palmsbetAPI: PalmsbetAPI): BaseRepository<About>(palmsbetAPI) {

    @Inject
    internal lateinit var sharedPreferencesCache: SharedPreferencesCache

    override fun getItems(): Single<About> = palmsBetApi.getAbout(username = sharedPreferencesCache.getData(SharedPreferencesCache.USERNAME_KEY)!!)
}