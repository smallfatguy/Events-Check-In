package com.belimov.cft_events_registrator.features.events.data

import com.belimov.cft_events_registrator.features.events.data.dto.EventDto
import io.reactivex.Observable
import retrofit2.http.GET

interface EventsApi {

    @GET("api/v1/Events/registration?token=cftte@mtest20!9")
    fun getEventsList(): Observable<ArrayList<EventDto>>
}