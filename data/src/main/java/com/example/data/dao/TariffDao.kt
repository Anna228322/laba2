package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.models.TariffEntity

@Dao
interface TariffDao {
    @Insert suspend fun saveAll(vararg tariff: TariffEntity)
    @Delete suspend fun delete(tariff: TariffEntity)
    @Query("select * from tariff")
    suspend fun getAll(): List<TariffEntity>
}