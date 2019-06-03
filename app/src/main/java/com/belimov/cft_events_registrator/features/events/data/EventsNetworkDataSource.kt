package com.belimov.cft_events_registrator.features.events.data

import com.belimov.cft_events_registrator.features.events.data.dto.EventDto
import com.belimov.cft_events_registrator.network.RetrofitProvider
import io.reactivex.Observable
import javax.inject.Inject

interface EventsNetworkDataSource {
    fun loadEvents(): Observable<ArrayList<EventDto>>
}

class EventsNetworkDataSourceImpl @Inject constructor(retrofitProvider: RetrofitProvider): EventsNetworkDataSource {
    private val eventsApi = retrofitProvider.provide().create(EventsApi::class.java)

    override fun loadEvents(): Observable<ArrayList<EventDto>> = eventsApi.getEventsList()


}