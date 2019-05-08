package com.appsbg.model.repository

import com.appsbg.model.api.PalmsbetAPI
import com.appsbg.model.poko.about.About
import dagger.Reusable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class AboutRepository @Inject constructor(palmsbetAPI: PalmsbetAPI): BaseRepository<About>(palmsbetAPI) {

    override fun getItems(args: Map<String, Any>?): Single<About> = palmsBetApi.getAbout()
}