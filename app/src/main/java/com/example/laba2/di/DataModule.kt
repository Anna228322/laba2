package com.example.laba2.di

import com.example.data.BalanceRepository
import com.example.data.TariffRepository
import com.example.data.UserInfoRepository
import com.example.domain.repository.IBalanceRepository
import com.example.domain.repository.ITariffRepository
import com.example.domain.repository.IUserInfoRepository
import com.example.network.retrofit.ApiProvider
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideUserInfoRepo(apiProvider: ApiProvider): IUserInfoRepository =
        UserInfoRepository(apiProvider)

    @Provides
    fun provideBalanceRepo(apiProvider: ApiProvider): IBalanceRepository =
        BalanceRepository(apiProvider)

    @Provides
    fun provideTariffRepo(apiProvider: ApiProvider): ITariffRepository =
        TariffRepository(apiProvider)
}