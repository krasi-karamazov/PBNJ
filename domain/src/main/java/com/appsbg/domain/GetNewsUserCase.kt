package com.appsbg.domain

import com.appsbg.model.poko.news.News
import com.appsbg.model.poko.news.NewsWrapper
import com.appsbg.model.repository.NewsRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetNewsUserCase @Inject constructor(val repo:NewsRepository): BaseUsecase<List<News>>(repo) {

    override fun getData(): Single<List<News>> {
        return repo.getItems()
    }

}