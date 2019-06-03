package com.belimov.cft_events_registrator.features.events.domain

import com.belimov.cft_events_registrator.features.events.domain.model.Event
import io.reactivex.Observable

interface EventsRepository {

    fun loadEvents(): Observable<List<Event>>
}