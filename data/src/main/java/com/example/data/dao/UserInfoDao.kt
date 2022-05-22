package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.models.UserInfoEntity

@Dao
interface UserInfoDao {
    @Insert suspend fun saveAll(vararg userinfo: UserInfoEntity)
    @Delete suspend fun delete(userinfo: UserInfoEntity)
    @Query("select * from userinfo")
    suspend fun getAll(): List<UserInfoEntity>
}