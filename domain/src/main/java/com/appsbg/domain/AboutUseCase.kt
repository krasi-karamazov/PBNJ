package com.appsbg.domain

import com.appsbg.model.poko.about.About
import com.appsbg.model.repository.AboutRepository
import io.reactivex.Single
import javax.inject.Inject

class AboutUseCase @Inject constructor(val repo: AboutRepository): BaseUsecase<About, String>(repo) {

    override fun getData(args: Map<String, Any>?): Single<String> {
        return repo.getItems(null)
            .flatMap { about -> Single.just(about.description) }
    }

}