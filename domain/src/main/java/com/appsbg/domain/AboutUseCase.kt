package com.appsbg.domain

import com.appsbg.model.poko.about.About
import com.appsbg.model.repository.AboutRepository
import io.reactivex.Single
import javax.inject.Inject

class AboutUseCase @Inject constructor(val repo: AboutRepository): BaseUsecase<About, String>(repo) {

    override fun getData(): Single<String> {
        return repo.getItems()
            .flatMap { about:About -> Single.just(about.description) }
    }

}