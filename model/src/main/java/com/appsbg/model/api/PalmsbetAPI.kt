package com.appsbg.model.api

import com.appsbg.model.poko.PalmsbetDataWrapper
import com.appsbg.model.poko.about.About
import com.appsbg.model.poko.casinos.CasinosWrapper
import com.appsbg.model.poko.city.City
import com.appsbg.model.poko.news.NewsWrapper
import com.appsbg.model.poko.notifications.Notification
import com.appsbg.model.poko.terms.Terms
import retrofit2.Call
import retrofit2.http.*

interface PalmsbetAPI {
    @GET("/api/get?news=1&casinos=1&cities=1&about=1&terms=1&news=1&api=1&locale=bg")
    fun getAll(@Header("user") user: String, @Header("pass") pass: String): Call<PalmsbetDataWrapper>

    @GET("/api/get?casinos=1locale=bg")
    fun getCasinos(@Header("user") user: String, @Header("pass") pass: String): Call<CasinosWrapper>

    @GET("/api/get?cities=1locale=bg")
    fun getCities(@Header("user") user: String, @Header("pass") pass: String): Call<City>

    @GET("/api/get?news=1locale=bg")
    fun getNews(@Header("user") user: String, @Header("pass") pass: String): Call<NewsWrapper>

    @GET("/api/get?notifications=1locale=bg")
    fun getNotifications(@Header("user") user: String, @Header("pass") pass: String, @Query("username") username: String): Call<Notification>

    @GET("/api/get?about=1locale=bg")
    fun getAbout(@Header("user") user: String, @Header("pass") pass: String, @Query("username") username: String): Call<About>

    @GET("/api/get?terms=1locale=bg")
    fun getTerms(@Header("user") user: String, @Header("pass") pass: String, @Query("username") username: String): Call<Terms>

    @POST("/api/push_tags")
    @FormUrlEncoded
    fun sendTags(
        @Header("user") user: String, @Header("pass") pass: String, @Field("username") username: String, @Field("tags") tags: String
    ): Call<Void>
}