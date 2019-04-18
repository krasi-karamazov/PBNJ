package com.appsbg.model.di

import com.appsbg.model.api.HostSelectionInterceptor
import com.appsbg.model.api.LoginApi
import com.appsbg.model.api.PALMSBET_BASE_URL
import com.appsbg.model.api.PalmsbetAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkingModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(PALMSBET_BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    internal fun providePalmsBetApi(retrofit: Retrofit): PalmsbetAPI = retrofit.create(PalmsbetAPI::class.java)

    @Provides
    @Singleton
    internal fun provideLoginApi(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java)

    @Provides
    @Singleton
    internal fun provideOkHttpClient(hostSelectionInterceptor: HostSelectionInterceptor): OkHttpClient {
        val loggingInterceptorBody = HttpLoggingInterceptor()
        loggingInterceptorBody.level = HttpLoggingInterceptor.Level.BODY

        val loggingInterceptorHeaders = HttpLoggingInterceptor()
        loggingInterceptorHeaders.level = HttpLoggingInterceptor.Level.HEADERS
        return OkHttpClient.Builder().cache(null)
            .addInterceptor(hostSelectionInterceptor)
            .addInterceptor(loggingInterceptorBody)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).build()
    }
}