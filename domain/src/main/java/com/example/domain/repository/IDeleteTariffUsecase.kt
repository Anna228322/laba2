package com.example.domain.repository

import com.example.domain.models.Tariff

interface IDeleteTariffUsecase {
    suspend operator fun invoke(tariff: Tariff): List<Tariff>
}