package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.models.LaunchEntity

@Dao
interface LaunchDao {
    @Query("Select * from launchentity")
    fun getAll(): List<LaunchEntity>

    @Insert
    fun addAll(vararg payments: LaunchEntity)

    @Delete
    fun delete(paymentEntity: LaunchEntity)
}