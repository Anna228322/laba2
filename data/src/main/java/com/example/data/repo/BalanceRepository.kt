package com.example.data.repo

import com.example.data.dao.BalanceDao
import com.example.data.models.BalanceEntity
import com.example.domain.models.Balance
import com.example.domain.repository.IBalanceRepository
import com.example.network.retrofit.ApiProvider

class BalanceRepository(
    private val apiProvider: ApiProvider,
    private val BalanceDao: BalanceDao
) : IBalanceRepository {
    override suspend fun getBalance(): Balance {
        val fromDb = BalanceDao.getAll()
        return if (fromDb.isNotEmpty()) {
            val entity = fromDb[0]
            Balance(entity.accNum, entity.balance, entity.nextPay, entity.id)
        } else {
            val fromApi = apiProvider.getApi().getBalance()[0]
            val mapped = BalanceEntity(fromApi.accNum, fromApi.balance, fromApi.nextPay, fromApi.id)
            BalanceDao.saveAll(mapped)
            fromApi
        }
    }
}