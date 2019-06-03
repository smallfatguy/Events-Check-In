package com.belimov.cft_events_registrator.di

import com.belimov.cft_events_registrator.features.checkin.di.CheckInModule
import com.belimov.cft_events_registrator.features.checkin.presentation.CheckInPresenter
import com.belimov.cft_events_registrator.features.events.di.EventsModule
import com.belimov.cft_events_registrator.features.events.presentation.EventsPresenter
import com.belimov.cft_events_registrator.network.NetworkModule
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        EventsModule::class,
        CheckInModule::class
    ]
)
@ApplicationScope
interface AppComponent {

    fun eventsPresenter(): EventsPresenter

    fun checkInPresenter(): CheckInPresenter
}