package com.appsbg.model.api

import com.appsbg.model.poko.PalmsbetDataWrapper
import com.appsbg.model.poko.about.About
import com.appsbg.model.poko.casinos.CasinosWrapper
import com.appsbg.model.poko.city.City
import com.appsbg.model.poko.news.NewsWrapper
import com.appsbg.model.poko.notifications.Notification
import com.appsbg.model.poko.terms.Terms
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface PalmsbetAPI {

    private companion object{

        const val API_USER = "palmsbet"
        const val API_PASS = "IUJhkmn63UhERSD99IUJKHBUUYGjhbyugGRTDsen"
    }

    @GET("/api/get?news=1&casinos=1&cities=1&about=1&terms=1&news=1&api=1&locale=bg")
    fun getAll(@Header("user") user: String = API_USER, @Header("pass") pass: String = API_PASS): Single<PalmsbetDataWrapper>

    @GET("/api/get?casinos=1locale=bg")
    fun getCasinos(@Header("user") user: String = API_USER, @Header("pass") pass: String = API_PASS): Single<CasinosWrapper>

    @GET("/api/get?cities=1locale=bg")
    fun getCities(@Header("user") user: String = API_USER, @Header("pass") pass: String = API_PASS): Single<City>

    @GET("/api/get?news=1locale=bg")
    fun getNews(@Header("user") user: String = API_USER, @Header("pass") pass: String = API_PASS): Single<NewsWrapper>

    @GET("/api/get?notifications=1locale=bg")
    fun getNotifications(@Header("user") user: String = API_USER, @Header("pass") pass: String = API_PASS, @Query("username") username: String): Single<Notification>

    @GET("/api/get?about=1locale=bg")
    fun getAbout(@Header("user") user: String = API_USER, @Header("pass") pass: String= API_PASS, @Query("username") username: String): Single<About>

    @GET("/api/get?terms=1locale=bg")
    fun getTerms(@Header("user") user: String = API_USER, @Header("pass") pass: String = API_PASS, @Query("username") username: String): Single<Terms>

    @POST("/api/push_tags")
    @FormUrlEncoded
    fun sendTags(@Header("user") user: String = API_USER, @Header("pass") pass: String = API_PASS, @Field("username") username: String, @Field("tags") tags: String
    ): Single<Void>
}