package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LaunchEntity (
    @PrimaryKey
    val id: Int,
    val date: String
    )