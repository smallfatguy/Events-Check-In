package com.belimov.cft_events_registrator.features.events.data

import com.belimov.cft_events_registrator.extensions.getCitiesAsString
import com.belimov.cft_events_registrator.extensions.getDate
import com.belimov.cft_events_registrator.features.events.domain.EventsRepository
import com.belimov.cft_events_registrator.features.events.domain.model.Event
import io.reactivex.Observable
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(private val dataSource: EventsNetworkDataSource): EventsRepository{
    override fun loadEvents(): Observable<List<Event>> {
        return dataSource.loadEvents().map {
            it.map {eventDto ->
                Event(
                    eventDto.cardImage,
                    eventDto.getCitiesAsString(),
                    eventDto.getDate(),
                    eventDto.description,
                    eventDto.id,
                    eventDto.status,
                    eventDto.title)
            }
        }
    }


}