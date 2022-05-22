package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.models.BalanceEntity

@Dao
interface BalanceDao {
    @Insert suspend fun saveAll(vararg balances: BalanceEntity)
    @Delete suspend fun delete(balance: BalanceEntity)
    @Query("select * from balance")
    suspend fun getAll(): List<BalanceEntity>
}