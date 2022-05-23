package com.example.laba2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Balance
import com.example.domain.models.Tariff
import com.example.domain.models.UserInfo
import com.example.domain.usecases.getbalance.IGetBalanceUseCase
import com.example.domain.usecases.gettariffs.DeleteTariffUsecase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import com.example.domain.usecases.getuserinfo.IGetUserInfoUseCase
import com.example.laba2.App
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(): IMainViewModel() {
    lateinit var balanceUseCase: IGetBalanceUseCase
    lateinit var tariffsUseCase: IGetTariffsUseCase
    lateinit var userInfoUseCase: IGetUserInfoUseCase
    lateinit var deleteTariffUsecase: DeleteTariffUsecase

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

    override fun delete(tariff: Tariff){
        viewModelScope.launch {
            loading.value = true
            val newList = deleteTariffUsecase(tariff)
            tariffs.value = newList
            loading.value = false
        }
    }
}