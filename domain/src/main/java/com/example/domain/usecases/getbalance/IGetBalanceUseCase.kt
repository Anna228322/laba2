package com.example.domain.usecases.getbalance

import com.example.domain.models.Balance

interface IGetBalanceUseCase {
    suspend fun getBalance(): Balance
}