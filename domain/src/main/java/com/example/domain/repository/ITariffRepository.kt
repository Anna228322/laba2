package com.example.domain.repository

import com.example.domain.models.Tariff

interface ITariffRepository {
    suspend fun getTariffs(): List<Tariff>
}