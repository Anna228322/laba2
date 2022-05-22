package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userinfo")
data class UserInfoEntity(
    val firstName: String,
    val lastName: String,
    val address: String,
    @PrimaryKey val id: String,
)
