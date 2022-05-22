package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tariff")
data class TariffEntity(
    val title: String,
    val desc: String,
    val cost: Int,
    @PrimaryKey val id: String
)
