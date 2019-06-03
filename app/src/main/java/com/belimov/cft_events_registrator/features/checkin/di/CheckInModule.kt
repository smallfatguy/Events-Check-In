package com.belimov.cft_events_registrator.features.checkin.di

import com.belimov.cft_events_registrator.features.checkin.data.CheckInNetworkDataSource
import com.belimov.cft_events_registrator.features.checkin.data.CheckInNetworkDataSourceImpl
import com.belimov.cft_events_registrator.features.checkin.data.CheckInRepositoryImpl
import com.belimov.cft_events_registrator.features.checkin.domain.CheckInInteractor
import com.belimov.cft_events_registrator.features.checkin.domain.CheckInInteractorImpl
import com.belimov.cft_events_registrator.features.checkin.domain.CheckInRepository
import dagger.Binds
import dagger.Module

@Module
interface CheckInModule {

    @Binds
    fun bindCheckInNetworkDataSource(impl: CheckInNetworkDataSourceImpl): CheckInNetworkDataSource

    @Binds
    fun bindCheckInRepository(impl: CheckInRepositoryImpl): CheckInRepository

    @Binds
    fun bindCheckInInteractor(impl: CheckInInteractorImpl): CheckInInteractor
}