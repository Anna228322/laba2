package com.example.laba2.di

import com.example.laba2.ui.TariffsFragment
import com.example.laba2.viewmodel.MainViewModel
import dagger.Component

@Component(modules = [
    AppModule::class,
    DataModule::class,
    NetworkModule::class,
])
interface IAppComponent {
    fun inject(activity: TariffsFragment)

    fun inject(vm: MainViewModel)
}