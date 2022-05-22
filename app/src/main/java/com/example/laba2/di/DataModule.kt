package com.example.laba2.di

import com.example.data.dao.BalanceDao
import com.example.data.dao.TariffDao
import com.example.data.dao.UserInfoDao
import com.example.data.repo.BalanceRepository
import com.example.data.repo.TariffRepository
import com.example.data.repo.UserInfoRepository
import com.example.domain.repository.IBalanceRepository
import com.example.domain.repository.ITariffRepository
import com.example.domain.repository.IUserInfoRepository
import com.example.network.retrofit.ApiProvider
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideUserInfoRepo(apiProvider: ApiProvider, userInfoDao: UserInfoDao): IUserInfoRepository =
        UserInfoRepository(apiProvider, userInfoDao)

    @Provides
    fun provideBalanceRepo(apiProvider: ApiProvider, balanceDao: BalanceDao): IBalanceRepository =
        BalanceRepository(apiProvider, balanceDao)

    @Provides
    fun provideTariffRepo(apiProvider: ApiProvider, tariffDao: TariffDao): ITariffRepository =
        TariffRepository(apiProvider, tariffDao)
}