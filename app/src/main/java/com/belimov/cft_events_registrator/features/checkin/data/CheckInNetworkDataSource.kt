package com.belimov.cft_events_registrator.features.checkin.data

import com.belimov.cft_events_registrator.features.checkin.data.dto.ConfirmationDto
import com.belimov.cft_events_registrator.features.checkin.data.dto.ParticipantDto
import com.belimov.cft_events_registrator.features.checkin.data.dto.SuccsessfulConfirm
import com.belimov.cft_events_registrator.network.RetrofitProvider
import io.reactivex.Observable
import javax.inject.Inject

interface CheckInNetworkDataSource {

    fun getParticipants(eventId: Int): Observable<List<ParticipantDto>>

    fun sendConfirmation(eventId: Int, confirmationDto: List<ConfirmationDto>): Observable<SuccsessfulConfirm>
}

class CheckInNetworkDataSourceImpl @Inject constructor(retrofitProvider: RetrofitProvider): CheckInNetworkDataSource {

    private val checkInApi: CheckInApi = retrofitProvider.provide().create(CheckInApi::class.java)

    override fun sendConfirmation(eventId: Int, confirmationDto: List<ConfirmationDto>): Observable<SuccsessfulConfirm> =
        checkInApi.confirmUser(eventId, confirmationDto)

    override fun getParticipants(eventId: Int): Observable<List<ParticipantDto>> = checkInApi.getParticipants(eventId)



}
