package com.appsbg.model.repository

import android.util.Base64
import com.appsbg.model.api.PalmsbetAPI
import com.appsbg.model.poko.session.SessionParamsPoko
import com.appsbg.model.poko.session.SessionRequestPoko
import io.reactivex.Single
import javax.inject.Inject
import com.squareup.moshi.Moshi



class LoginRepository @Inject constructor(private var palmsbetAPI: PalmsbetAPI) : BaseRepository<String>(palmsbetAPI) {

    companion object{
        const val PASSWORD_KEY = "password"
        const val USER_NAME_KEY = "username"
    }

    override fun getItems(args: Map<String, Any>?): Single<String> {
        if(!areArgsValid(args, PASSWORD_KEY, USER_NAME_KEY)){
            return Single.just(null)
        }
        return palmsbetAPI.encryptPassword(encryptedPass = getEncryptedPassword(args?.get(PASSWORD_KEY) as String))
            .map { t ->
                val sessionParamsPoko = SessionParamsPoko(args[USER_NAME_KEY] as String, t)
                val sessionRequestPoko = SessionRequestPoko(params = sessionParamsPoko)

                val moshi = Moshi.Builder().build()
                val jsonAdapter = moshi.adapter<SessionRequestPoko>(SessionRequestPoko::class.java!!)
                val json = jsonAdapter.toJson(sessionRequestPoko)
                palmsbetAPI.getSession(json)
            }
    }

    private fun getEncryptedPassword(plainTextPass: String): String {
        return String(Base64.encode(plainTextPass.toByteArray(), Base64.DEFAULT))
    }

}