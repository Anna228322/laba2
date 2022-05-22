package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balance")
data class BalanceEntity(
    val accNum: Int,
    val balance: Double,
    val nextPay: Double,
    @PrimaryKey val id: String
)
