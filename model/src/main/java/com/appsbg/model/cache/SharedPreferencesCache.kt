package com.appsbg.model.cache

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesCache @Inject constructor(val sharedPreferences: SharedPreferences): Cache<String, String> {

    companion object{
        val USERNAME_KEY = "username"
    }

    override fun saveData(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun getData(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
}