package com.example.laba2.di

import com.example.network.retrofit.ApiProvider
import com.example.network.retrofit.IApi
import com.example.network.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideRetrofitClient(): RetrofitClient =
        RetrofitClient()

    @Provides
    fun provideApiProvider(client: RetrofitClient): ApiProvider =
        ApiProvider(client)

    @Provides
    fun provideApi(apiProvider: ApiProvider): IApi =
        apiProvider.getApi()
}
