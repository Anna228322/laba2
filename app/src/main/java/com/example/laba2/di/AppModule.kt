package com.example.laba2.di

import android.content.Context
import androidx.room.Room
import com.example.data.Database
import com.example.domain.repository.IBalanceRepository
import com.example.domain.repository.IDeleteTariffUsecase
import com.example.domain.repository.ITariffRepository
import com.example.domain.repository.IUserInfoRepository
import com.example.domain.usecases.getbalance.GetBalanceUseCase
import com.example.domain.usecases.getbalance.IGetBalanceUseCase
import com.example.domain.usecases.gettariffs.DeleteTariffUsecase
import com.example.domain.usecases.gettariffs.GetTariffsUseCase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import com.example.domain.usecases.getuserinfo.GetUserInfoUseCase
import com.example.domain.usecases.getuserinfo.IGetUserInfoUseCase
import com.example.laba2.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {
    @Provides 
    fun provideViewModel(): MainViewModel =
        MainViewModel()

    @Provides 
    fun provideUserInfoUseCase(repo: IUserInfoRepository): IGetUserInfoUseCase =
        GetUserInfoUseCase(repo)

    @Provides
    fun provideDatabase(context: Context) =
        Room.databaseBuilder(context, Database::class.java, "db")
            .build()

    @Provides fun provideBalanceDao(database: Database) = database.getBalanceDao()
    @Provides fun provideTariffDao(database: Database) = database.getTariffDao()
    @Provides fun provideUserDao(database: Database) = database.getUserInfoDao()

    @Provides fun provideContext() = context

    @Provides 
    fun provideBalanceUseCase(repo: IBalanceRepository): IGetBalanceUseCase =
        GetBalanceUseCase(repo)

    @Provides 
    fun provideTariffUseCase(repo: ITariffRepository): IGetTariffsUseCase =
        GetTariffsUseCase(repo)

    @Provides
    fun provideDeleteTariffUseCase(repo: ITariffRepository): IDeleteTariffUsecase =
        DeleteTariffUsecase(repo)
}