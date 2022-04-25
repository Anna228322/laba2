package com.example.laba2.DI

import com.example.laba2.UI.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class]) @Singleton
interface IAppComponent {
    fun inject(activity: MainActivity)
}