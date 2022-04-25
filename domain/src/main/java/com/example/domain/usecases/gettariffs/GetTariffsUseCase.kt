package com.example.domain.usecases.gettariffs

import com.example.domain.models.Tariff
import com.example.domain.repository.ITariffRepository

class GetTariffsUseCase (
    private val repo: ITariffRepository
    ):IGetTariffsUseCase {
    override suspend fun getTariffs(): List<Tariff> = repo.getTariffs()
}