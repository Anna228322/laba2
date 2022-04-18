package com.example.laba2.Network.retrofit

import com.example.laba2.Network.models.Balance
import com.example.laba2.Network.models.Tariff
import com.example.laba2.Network.models.UserInfo
import retrofit2.Call
import retrofit2.http.GET

interface IApi {
    @GET("UserInfo")
    fun getUserInfo(): Call<List<UserInfo>>

    @GET ("tariffs")
    fun getTariffs(): Call<List<Tariff>>

    @GET ("balance")
    fun getBalance(): Call<List<Balance>>
}