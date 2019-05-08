package com.appsbg.domain

import com.appsbg.model.repository.LoginRepository
import io.reactivex.Single
import javax.inject.Inject

class GetSessionUseCase @Inject constructor(private var repo: LoginRepository): BaseUsecase<String, String>(repo) {
    override fun getData(args: Map<String, Any>?): Single<String> {
        return repo.getItems(args)
    }

}