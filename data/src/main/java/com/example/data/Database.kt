package com.example.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dao.BalanceDao
import com.example.data.dao.TariffDao
import com.example.data.dao.UserInfoDao
import com.example.data.models.BalanceEntity
import com.example.data.models.TariffEntity
import com.example.data.models.UserInfoEntity

@Database(entities = [
    TariffEntity::class,
    BalanceEntity::class,
    UserInfoEntity::class
], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun getUserInfoDao(): UserInfoDao
    abstract fun getTariffDao(): TariffDao
    abstract fun getBalanceDao(): BalanceDao
}