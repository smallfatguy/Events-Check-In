package com.belimov.cft_events_registrator.features.events.domain

import com.belimov.cft_events_registrator.features.events.domain.model.Event
import io.reactivex.Observable
import javax.inject.Inject

interface EventsInteractor {
    fun loadEvents(): Observable<List<Event>>
}

class EventsInteractorImpl @Inject constructor(
    private val repository: EventsRepository
): EventsInteractor {

    override fun loadEvents(): Observable<List<Event>> =
        repository.loadEvents()


}