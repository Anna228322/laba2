package com.example.laba2

import android.app.Application
import com.example.laba2.di.DaggerIAppComponent
import com.example.laba2.di.IAppComponent

class App: Application() {
    companion object {
        lateinit var appComponent: IAppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerIAppComponent.create()
    }
}