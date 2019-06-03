package com.belimov.cft_events_registrator.features.checkin.domain

import com.belimov.cft_events_registrator.features.checkin.domain.model.Participant
import io.reactivex.Observable
import javax.inject.Inject

interface CheckInInteractor {

    fun loadParticipants(eventId: Int): Observable<List<Participant>>

    fun confirmPaticipant(eventId: Int, participant: Participant): Observable<String>
}

class CheckInInteractorImpl @Inject constructor(private val repository: CheckInRepository): CheckInInteractor {
    override fun confirmPaticipant(eventId: Int, participant: Participant): Observable<String> =
        repository.confirmParticipant(eventId, participant)

    override fun loadParticipants(eventId: Int): Observable<List<Participant>> =
        repository.loadParticipants(eventId)

}