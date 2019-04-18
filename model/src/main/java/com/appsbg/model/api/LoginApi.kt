package com.appsbg.model.api

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoginApi {

    @GET("/centr-api?")
    fun getSession(@Query("payload_jsonrpc") jsonString: String, @Query("api_key") apiKey: String = "myPlay/b93d8fecv8016d3155dc09996d65fe5f", @Query("checksum") checksum: String = "2828d8786c9323cb9a47846bb974d0a1")


    @GET("/api/e/?")
    fun encryptPassword(@Header("user") user: String, @Header("pass") pass: String, @Query("i[]") encryptedPass: String)

}