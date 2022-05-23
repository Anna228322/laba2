package com.example.domain.usecases.getbalance

import com.example.domain.models.Balance
import com.example.domain.repository.IBalanceRepository
import javax.inject.Inject

class GetBalanceUseCase @Inject constructor (
    private val repo: IBalanceRepository
): IGetBalanceUseCase {
    override suspend fun getBalance(): Balance = repo.getBalance()
}