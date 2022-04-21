package com.example.laba2.Network.retrofit

import com.example.laba2.Network.models.Balance
import com.example.laba2.Network.models.Tariff
import com.example.laba2.Network.models.UserInfo
import retrofit2.Call
import retrofit2.http.GET

interface IApi {
    @GET("UserInfo")
    suspend fun getUserInfo(): List<UserInfo>

    @GET ("tariffs")
    suspend fun getTariffs(): List<Tariff>

    @GET ("balance")
    suspend fun getBalance(): List<Balance>
}