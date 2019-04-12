package com.appsbg.model.repository

import com.appsbg.model.api.PalmsbetAPI
import io.reactivex.Single

abstract class BaseRepository<T> constructor(val palmsBetApi: PalmsbetAPI){
    abstract fun getItems(): Single<T>
}