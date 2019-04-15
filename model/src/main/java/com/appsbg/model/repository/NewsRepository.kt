package com.appsbg.model.repository

import com.appsbg.model.api.PalmsbetAPI
import com.appsbg.model.poko.news.News
import com.appsbg.model.poko.news.NewsWrapper
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(palmsbetAPI: PalmsbetAPI): BaseRepository<List<News>>(palmsbetAPI){
    override fun getItems(): Single<List<News>> {
        return palmsBetApi.getNews().flatMap { wrapper: NewsWrapper -> Single.just(wrapper.news) }
    }
}