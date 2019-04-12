package com.appsbg.model.cache

interface Cache<K, V> {
    fun saveData(key: K, value: V)
    fun getData(key: K): V?
}