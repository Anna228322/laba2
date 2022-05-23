package com.example.laba2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Balance
import com.example.domain.models.Tariff
import com.example.domain.models.UserInfo

abstract class IMainViewModel: ViewModel() {
    abstract val balance: LiveData<Balance>
    abstract val tariffs: LiveData<List<Tariff>>
    abstract val userInfo: LiveData<UserInfo>
    abstract val loading: LiveData<Boolean>
    abstract fun delete(tariff: Tariff)

    abstract fun refreshData()
}
