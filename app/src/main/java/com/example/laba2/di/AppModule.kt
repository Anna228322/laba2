package com.example.laba2.di

import com.example.domain.repository.IBalanceRepository
import com.example.domain.repository.ITariffRepository
import com.example.domain.repository.IUserInfoRepository
import com.example.domain.usecases.getbalance.GetBalanceUseCase
import com.example.domain.usecases.getbalance.IGetBalanceUseCase
import com.example.domain.usecases.gettariffs.GetTariffsUseCase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import com.example.domain.usecases.getuserinfo.GetUserInfoUseCase
import com.example.domain.usecases.getuserinfo.IGetUserInfoUseCase
import com.example.laba2.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides 
    fun provideViewModel(): MainViewModel =
        MainViewModel()

    @Provides 
    fun provideUserInfoUseCase(repo: IUserInfoRepository): IGetUserInfoUseCase =
        GetUserInfoUseCase(repo)

    @Provides 
    fun provideBalanceUseCase(repo: IBalanceRepository): IGetBalanceUseCase =
        GetBalanceUseCase(repo)

    @Provides 
    fun provideTariffUseCase(repo: ITariffRepository): IGetTariffsUseCase =
        GetTariffsUseCase(repo)
}