package com.example.domain.models

data class Balance(
    val accNum: Int,
    val balance: Double,
    val nextPay: Double,
    val id: String
)
