package com.example.network.retrofit

import com.example.domain.models.Balance
import com.example.domain.models.Tariff
import com.example.domain.models.UserInfo
import retrofit2.http.GET

interface IApi {
    @GET("userInfo")
    suspend fun getUserInfo(): List<UserInfo>

    @GET ("tariffs")
    suspend fun getTariffs(): List<Tariff>

    @GET ("balance")
    suspend fun getBalance(): List<Balance>
}