package com.example.laba2.di

import androidx.fragment.app.Fragment
import com.example.laba2.App
import com.example.laba2.ui.TariffsFragment
import com.example.laba2.viewmodel.MainViewModel
import com.example.laba2.viewmodel.ViewModelFactory
import dagger.Component

@Component(modules = [
    AppModule::class,
    DataModule::class,
    NetworkModule::class,
    UsecaseModule::class,
    ViewModelModule::class
])
interface IAppComponent {
    fun inject(activity: TariffsFragment)
    fun factory(): ViewModelFactory

    fun inject(vm: MainViewModel)
}

val Fragment.factory get() = (requireContext().applicationContext as App).appComponent.factory()