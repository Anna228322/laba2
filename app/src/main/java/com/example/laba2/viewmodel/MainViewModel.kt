package com.example.laba2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Balance
import com.example.domain.models.Tariff
import com.example.domain.models.UserInfo
import com.example.domain.usecases.getbalance.IGetBalanceUseCase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import com.example.domain.usecases.getuserinfo.IGetUserInfoUseCase
import kotlinx.coroutines.launch

class MainViewModel (
    private val balanceUseCase: IGetBalanceUseCase,
    private val tariffsUseCase: IGetTariffsUseCase,
    private val userInfoUseCase: IGetUserInfoUseCase
): IMainViewModel() {
    override val balance = MutableLiveData<Balance>()
    override val tariffs = MutableLiveData<List<Tariff>>()
    override val userInfo = MutableLiveData<UserInfo>()
    override val loading = MutableLiveData(false)

    override fun refreshData() {
        viewModelScope.launch {
            loading.value = true
            balance.value = balanceUseCase.getBalance()
            tariffs.value = tariffsUseCase.getTariffs()
            userInfo.value = userInfoUseCase.getUserInfo()
            loading.value = false

        }
    }

}