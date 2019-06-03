package com.belimov.cft_events_registrator.features.events.di

import com.belimov.cft_events_registrator.features.events.data.EventsNetworkDataSource
import com.belimov.cft_events_registrator.features.events.data.EventsNetworkDataSourceImpl
import com.belimov.cft_events_registrator.features.events.data.EventsRepositoryImpl
import com.belimov.cft_events_registrator.features.events.domain.EventsInteractor
import com.belimov.cft_events_registrator.features.events.domain.EventsInteractorImpl
import com.belimov.cft_events_registrator.features.events.domain.EventsRepository
import dagger.Binds
import dagger.Module

@Module
interface EventsModule {

    @Binds
    fun bindEventsInteractor(impl: EventsInteractorImpl): EventsInteractor

    @Binds
    fun bindEventsRepository(impl: EventsRepositoryImpl): EventsRepository

    @Binds
    fun bindEventsNetworkdataSource(impl: EventsNetworkDataSourceImpl): EventsNetworkDataSource
}