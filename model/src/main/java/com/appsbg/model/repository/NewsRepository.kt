package com.appsbg.model.repository

import com.appsbg.model.api.PalmsbetAPI
import com.appsbg.model.poko.news.NewsWrapper
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(palmsbetAPI: PalmsbetAPI): BaseRepository<NewsWrapper>(palmsbetAPI){
    override fun getItems(): Single<NewsWrapper> {
        palmsbetAPI
    }
}