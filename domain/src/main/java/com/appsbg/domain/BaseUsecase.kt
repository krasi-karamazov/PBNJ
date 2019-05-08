package com.appsbg.domain

import com.appsbg.model.repository.BaseRepository
import io.reactivex.Single

abstract class BaseUsecase<RepositoryReturnType, UseCaseReturnType> constructor(val baseRepository: BaseRepository<RepositoryReturnType>) {
    abstract fun getData(args: Map<String, Any>?): Single<UseCaseReturnType>
}