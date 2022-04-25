package com.example.data

import com.example.domain.models.Tariff
import com.example.domain.repository.ITariffRepository
import com.example.network.retrofit.ApiProvider

class TariffRepository(private val apiProvider: ApiProvider) :ITariffRepository {
    override suspend fun getTariffs(): List<Tariff> = apiProvider.getApi().getTariffs()
}