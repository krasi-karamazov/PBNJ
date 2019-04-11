package com.appsbg.model.repository

import com.appsbg.model.poko.news.NewsWrapper
import io.reactivex.Single

class NewsRepository: BaseRepository<NewsWrapper>() {
    override fun getItems(): Single<NewsWrapper> {

    }
}