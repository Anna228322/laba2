package com.example.domain.repository

import com.example.domain.models.Balance

interface IBalanceRepository {
    suspend fun getBalance(): Balance
}