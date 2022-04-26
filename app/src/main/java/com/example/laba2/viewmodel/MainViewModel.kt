package com.example.laba2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Balance
import com.example.domain.models.Tariff
import com.example.domain.models.UserInfo
import com.example.domain.usecases.getbalance.IGetBalanceUseCase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import com.example.domain.usecases.getuserinfo.IGetUserInfoUseCase
import com.example.laba2.App
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel: IMainViewModel() {
    @Inject lateinit var balanceUseCase: IGetBalanceUseCase
    @Inject lateinit var tariffsUseCase: IGetTariffsUseCase
    @Inject lateinit var userInfoUseCase: IGetUserInfoUseCase

    override val balance = MutableLiveData<Balance>()
    override val tariffs = MutableLiveData<List<Tariff>>()
    override val userInfo = MutableLiveData<UserInfo>()
    override val loading = MutableLiveData(false)

    init {
        App.appComponent.inject(this)
    }

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