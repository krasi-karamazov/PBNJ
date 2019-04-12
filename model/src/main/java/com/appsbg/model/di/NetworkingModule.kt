package com.appsbg.model.di

import com.appsbg.model.api.AuthorizationInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
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
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        return createHttpClient(CLIENT_KEY, CLIENT_SECRET)
    }

    @Provides
    @Singleton
    @Named("chaptersOkHttpClient")
    internal fun provideChaptersOkHttpClient(): OkHttpClient {
        return createHttpClient(CLIENT_KEY_CHAPTERS, CLIENT_SECRET_CHAPTERS)
    }

    private fun createHttpClient(clientKey: String, clientSecret: String): OkHttpClient {
        val loggingInterceptorBody = HttpLoggingInterceptor()
        loggingInterceptorBody.level = HttpLoggingInterceptor.Level.BODY

        val loggingInterceptorHeaders = HttpLoggingInterceptor()
        loggingInterceptorHeaders.level = HttpLoggingInterceptor.Level.HEADERS
        return OkHttpClient.Builder().cache(null).addInterceptor(AuthorizationInterceptor(clientKey, clientSecret)).addInterceptor(loggingInterceptorBody).connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build()
    }
}