package com.example.laba2.DI

import com.example.data.BalanceRepository
import com.example.data.TariffRepository
import com.example.data.UserInfoRepository
import com.example.domain.repository.IBalanceRepository
import com.example.domain.repository.ITariffRepository
import com.example.domain.repository.IUserInfoRepository
import com.example.domain.usecases.getbalance.GetBalanceUseCase
import com.example.domain.usecases.getbalance.IGetBalanceUseCase
import com.example.domain.usecases.gettariffs.GetTariffsUseCase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import com.example.domain.usecases.getuserinfo.GetUserInfoUseCase
import com.example.domain.usecases.getuserinfo.IGetUserInfoUseCase
import com.example.laba2.viewmodel.ViewModelFactory
import com.example.network.retrofit.ApiProvider
import com.example.network.retrofit.IApi
import com.example.network.retrofit.RetrofitClient

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides @Singleton
    fun provideViewModelFactory(
        tariffsUseCase: IGetTariffsUseCase,
        balanceUseCase: IGetBalanceUseCase,
        userInfoUseCase: IGetUserInfoUseCase
    ): ViewModelFactory =
        ViewModelFactory(balanceUseCase, tariffsUseCase, userInfoUseCase)

    @Provides @Singleton
    fun provideRetrofitClient(): RetrofitClient =
        RetrofitClient()

    @Provides @Singleton
    fun provideApiProvider(client: RetrofitClient): ApiProvider =
        ApiProvider(client)

    @Provides @Singleton
    fun provideApi(apiProvider: ApiProvider): IApi =
        apiProvider.getApi()

    @Provides @Singleton
    fun provideUserInfoRepo(apiProvider: ApiProvider): IUserInfoRepository =
        UserInfoRepository(apiProvider)

    @Provides @Singleton
    fun provideBalanceRepo(apiProvider: ApiProvider): IBalanceRepository =
        BalanceRepository(apiProvider)

    @Provides @Singleton
    fun provideTariffRepo(apiProvider: ApiProvider): ITariffRepository =
        TariffRepository(apiProvider)


    @Provides @Singleton
    fun provideUserInfoUseCase(repo: IUserInfoRepository): IGetUserInfoUseCase =
        GetUserInfoUseCase(repo)

    @Provides @Singleton
    fun provideBalanceUseCase(repo: IBalanceRepository): IGetBalanceUseCase =
        GetBalanceUseCase(repo)

    @Provides @Singleton
    fun provideTariffUseCase(repo: ITariffRepository): IGetTariffsUseCase =
        GetTariffsUseCase(repo)
}