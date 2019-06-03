package com.belimov.cft_events_registrator.features.checkin.domain

import com.belimov.cft_events_registrator.features.checkin.domain.model.Participant
import io.reactivex.Observable

interface CheckInRepository {

    fun loadParticipants(eventId: Int): Observable<List<Participant>>

    fun confirmParticipant(eventId: Int, participant: Participant): Observable<String>
}