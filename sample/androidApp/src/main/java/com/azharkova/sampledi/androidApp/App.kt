package com.azharkova.sampledi.androidApp

import android.app.Application
import android.content.Context
import com.azharkova.sampledi.shared.config.ConfigurationApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        val config = ConfigurationApp()
        val container = config.appContainer
        lateinit var INSTANCE:App
        var AppContext: Context? = null
    }
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        AppContext = this
    }
}