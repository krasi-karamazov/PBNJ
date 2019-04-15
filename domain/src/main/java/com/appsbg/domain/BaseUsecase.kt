package com.appsbg.domain

import com.appsbg.model.repository.BaseRepository
import io.reactivex.Single

open abstract class BaseUsecase<T> constructor(val baseRepository: BaseRepository<T>) {
    abstract fun getData(): Single<T>
}