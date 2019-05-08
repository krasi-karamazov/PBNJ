package com.appsbg.model.repository

import com.appsbg.model.api.PalmsbetAPI
import com.appsbg.model.poko.news.NewsWrapper
import dagger.Reusable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class NewsRepository @Inject constructor(palmsbetAPI: PalmsbetAPI): BaseRepository<NewsWrapper>(palmsbetAPI){
    override fun getItems(args: Map<String, Any>?): Single<NewsWrapper> {
        return palmsBetApi.getNews()
    }
}