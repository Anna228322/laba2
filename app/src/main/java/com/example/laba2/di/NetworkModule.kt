package com.example.laba2.di

import com.example.network.retrofit.IApi
import com.example.network.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideApi(client: RetrofitClient): IApi = client.getClient()
}
