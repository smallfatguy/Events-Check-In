package com.belimov.cft_events_registrator

import android.app.Application
import com.belimov.cft_events_registrator.di.AppComponent
import com.belimov.cft_events_registrator.di.DaggerAppComponent

class App: Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }

}