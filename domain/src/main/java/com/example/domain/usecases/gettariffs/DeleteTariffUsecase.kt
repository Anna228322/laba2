package com.example.domain.usecases.gettariffs

import com.example.domain.models.Tariff
import com.example.domain.repository.IDeleteTariffUsecase
import com.example.domain.repository.ITariffRepository
import javax.inject.Inject

class DeleteTariffUsecase @Inject constructor(
    private val repo: ITariffRepository
): IDeleteTariffUsecase {
    override suspend fun invoke(tariff: Tariff): List<Tariff> {
        return repo.deleteTariff(tariff)
    }
}