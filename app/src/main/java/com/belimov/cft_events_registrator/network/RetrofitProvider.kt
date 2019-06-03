package com.belimov.cft_events_registrator.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL: String = "https://team.cft.ru"
private const val RETROFIT_TAG: String = "Retrofit"

interface RetrofitProvider {
    fun provide(): Retrofit
}

class RetrofitProviderImpl: RetrofitProvider{
    override fun provide(): Retrofit = retrofit

    val retrofit: Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .client(createClient())
            .build()


    fun createClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        val logInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Log.d(RETROFIT_TAG, it) })
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        builder.addInterceptor(logInterceptor)

        return builder.build()
    }

}
