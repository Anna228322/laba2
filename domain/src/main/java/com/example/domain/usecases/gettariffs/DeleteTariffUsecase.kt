package com.example.domain.usecases.gettariffs

import com.example.domain.models.Tariff
import com.example.domain.repository.IDeleteTariffUsecase
import com.example.domain.repository.ITariffRepository

class DeleteTariffUsecase(
    private val repo: ITariffRepository
): IDeleteTariffUsecase {
    override suspend fun invoke(tariff: Tariff): List<Tariff> {
        return repo.deleteTariff(tariff)
    }
}