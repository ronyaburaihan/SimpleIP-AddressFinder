package com.techdoctorbd.findmyipaddress.network

import com.techdoctorbd.findmyipaddress.models.ServerResponse
import retrofit2.Call

import retrofit2.http.GET


interface ApiInterface {
    @GET("/json")
    fun getMyIp(): Call<ServerResponse?>?
}