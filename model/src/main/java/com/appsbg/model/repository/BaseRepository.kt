package com.appsbg.model.repository

import com.appsbg.model.api.PalmsbetAPI
import io.reactivex.Single

abstract class BaseRepository<T> constructor(protected val palmsBetApi: PalmsbetAPI){
    abstract fun getItems(args: Map<String, Any>?): Single<T>

    protected fun areArgsValid(args: Map<String, Any>?, vararg requiredKeys: String): Boolean {
        if(args != null){
            for(key in requiredKeys) {
                if(!args.containsKey(key)){
                    return false
                }
            }
            return true
        }else {
            return false
        }
    }
}