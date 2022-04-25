package com.example.laba2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.getbalance.IGetBalanceUseCase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import com.example.domain.usecases.getuserinfo.IGetUserInfoUseCase

class ViewModelFactory(
    private val balanceUseCase: IGetBalanceUseCase,
    private val tariffsUseCase: IGetTariffsUseCase,
    private val userInfoUseCase: IGetUserInfoUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel (
            balanceUseCase, tariffsUseCase, userInfoUseCase
        ) as T
    }
}