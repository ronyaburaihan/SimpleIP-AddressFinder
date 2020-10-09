package com.techdoctorbd.findmyipaddress.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitApiClient {
    private const val BASE_URL = "https://ifconfig.co"
    private var retrofit: Retrofit? = null
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    //thread safe Singleton implementation
    fun getClient(): Retrofit? {
        if (retrofit == null) {
            synchronized(RetrofitApiClient::class.java) { //thread safe Singleton implementation
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
                }
            }
        }
        return retrofit
    }

}