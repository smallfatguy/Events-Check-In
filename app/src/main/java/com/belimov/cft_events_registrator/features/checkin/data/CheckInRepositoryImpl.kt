package com.belimov.cft_events_registrator.features.checkin.data

import com.belimov.cft_events_registrator.extensions.getDate
import com.belimov.cft_events_registrator.extensions.transformToConfirmationDto
import com.belimov.cft_events_registrator.features.checkin.domain.CheckInRepository
import com.belimov.cft_events_registrator.features.checkin.domain.model.Participant
import io.reactivex.Observable
import javax.inject.Inject

class CheckInRepositoryImpl @Inject constructor(private val networkDataSource: CheckInNetworkDataSource): CheckInRepository {

    override fun confirmParticipant(eventId: Int, participant: Participant): Observable<String> =
        networkDataSource.sendConfirmation(eventId, participant.transformToConfirmationDto()).map { "${participant.lastName} ${participant.firstName}" }

    override fun loadParticipants(eventId: Int): Observable<List<Participant>> =
        networkDataSource.getParticipants(eventId)
            .map {
                it.map {
                    Participant(
                        it.agreedByManager,
                        it.city,
                        it.company,
                        it.email,
                        it.firstName,
                        it.id,
                        it.isVisited,
                        it.lastName,
                        it.phone,
                        it.getDate()
                    )
                }
            }
}