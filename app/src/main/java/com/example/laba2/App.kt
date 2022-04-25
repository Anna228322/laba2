package com.example.laba2

import android.app.Application
import com.example.laba2.DI.DaggerIAppComponent
import com.example.laba2.DI.IAppComponent

class App: Application() {
    companion object {
        lateinit var appComponent: IAppComponent
    }

    private lateinit var _appComponent: IAppComponent

    override fun onCreate() {
        super.onCreate()

        initDagger()
    }

    private fun initDagger() {
        _appComponent = DaggerIAppComponent.create()
        appComponent = _appComponent
    }
}