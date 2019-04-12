package com.appsbg.model.cache

import javax.inject.Inject

class InMemoryCache @Inject constructor(): Cache<String, String> {

    private val innerCache: MutableMap<String, String> = mutableMapOf()
    override fun saveData(key: String, value: String) {
        innerCache[key] = value
    }

    override fun getData(key: String): String?{
        return if (innerCache.containsKey(key)) {
            innerCache[key]
        }else{
            null
        }
    }
}