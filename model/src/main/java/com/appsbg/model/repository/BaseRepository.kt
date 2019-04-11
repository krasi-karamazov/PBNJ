package com.appsbg.model.repository

import io.reactivex.Single

abstract class BaseRepository<T>{
    abstract fun getItems(): Single<T>
}