package com.example.laba2

import android.app.Application
import com.example.laba2.di.AppModule
import com.example.laba2.di.IAppComponent
import com.example.laba2.di.DaggerIAppComponent

class App: Application() {
    lateinit var appComponent: IAppComponent

    override fun onCreate() {
        super.onCreate()

        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerIAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}