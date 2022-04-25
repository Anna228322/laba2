package com.example.domain.usecases.gettariffs

import com.example.domain.models.Tariff

interface IGetTariffsUseCase {
    suspend fun getTariffs(): List<Tariff>
}