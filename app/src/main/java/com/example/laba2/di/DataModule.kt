package com.example.laba2.di

import android.content.Context
import androidx.room.Room
import com.example.data.Database
import com.example.data.dao.BalanceDao
import com.example.data.dao.TariffDao
import com.example.data.dao.UserInfoDao
import com.example.data.migrations.Migration_1_2
import com.example.data.repo.BalanceRepository
import com.example.data.repo.TariffRepository
import com.example.data.repo.UserInfoRepository
import com.example.domain.repository.IBalanceRepository
import com.example.domain.repository.ITariffRepository
import com.example.domain.repository.IUserInfoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [DataBindsModule::class])
class DataModule {
    @Provides
    fun provideDatabase(context: Context): Database =
        Room.databaseBuilder(context, Database::class.java, "db").addMigrations(Migration_1_2).build()

    @Provides
    fun provideTariffsDao(database: Database): TariffDao = database.getTariffDao()

    @Provides
    fun provideUserDao(database: Database): UserInfoDao = database.getUserInfoDao()

    @Provides
    fun provideBalanceDao(database: Database): BalanceDao = database.getBalanceDao()
}

@Module
abstract class DataBindsModule {
    @Binds
    abstract fun bindBalanceRepo(balanceRepository: BalanceRepository): IBalanceRepository

    @Binds
    abstract fun bindUserRepo(userRepository: UserInfoRepository): IUserInfoRepository

    @Binds
    abstract fun bindTariffsRepo(tariffsRepository: TariffRepository): ITariffRepository
}