package com.example.data.repo

import com.example.data.dao.TariffDao
import com.example.data.models.TariffEntity
import com.example.domain.models.Tariff
import com.example.domain.repository.ITariffRepository
import com.example.network.retrofit.RetrofitClient
import javax.inject.Inject

class TariffRepository @Inject constructor(
    private val retrofitClient: RetrofitClient,
    private val tariffDao: TariffDao
): ITariffRepository {
    override suspend fun getTariffs(): List<Tariff> {
        val fromDb = tariffDao.getAll()
        return if (fromDb.isNotEmpty()) {
            fromDb.map { Tariff(it.title, it.desc, it.cost, it.id) }
        } else {
            val fromApi = retrofitClient.getClient().getTariffs()
            val mapped = fromApi.map { TariffEntity(it.title, it.desc, it.cost, it.id) }
            tariffDao.saveAll(*mapped.toTypedArray())
            fromApi
        }
    }

    override suspend fun deleteTariff(tariff: Tariff) : List<Tariff> {
        tariffDao.delete(TariffEntity(tariff.title, tariff.desc, tariff.cost, tariff.id))
        return tariffDao.getAll().map { Tariff(it.title, it.desc, it.cost, it.id) }
    }
}