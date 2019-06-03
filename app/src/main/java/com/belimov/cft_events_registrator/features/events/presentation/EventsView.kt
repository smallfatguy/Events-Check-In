package com.belimov.cft_events_registrator.features.events.presentation

import com.belimov.cft_events_registrator.features.BaseView
import com.belimov.cft_events_registrator.features.events.domain.model.Event

interface EventsView: BaseView {

    fun loadEvents(events: ArrayList<Event>)
}