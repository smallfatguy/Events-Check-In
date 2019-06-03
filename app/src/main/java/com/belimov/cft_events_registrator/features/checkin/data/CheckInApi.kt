package com.belimov.cft_events_registrator.features.checkin.data

import com.belimov.cft_events_registrator.features.checkin.data.dto.ConfirmationDto
import com.belimov.cft_events_registrator.features.checkin.data.dto.ParticipantDto
import com.belimov.cft_events_registrator.features.checkin.data.dto.SuccsessfulConfirm
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CheckInApi {

    @GET("/api/v1/Registration/members/event/{eventId}?token=cftte@mtest20!9")
    fun getParticipants(@Path("eventId") eventId: Int): Observable<List<ParticipantDto>>

    @POST("/api/v1/Registration/members/event/{eventId}/confirmation?token=cftte@mtest20!9")
    fun confirmUser(@Path("eventId") eventId: Int, @Body confirmationDto: List<ConfirmationDto>): Observable<SuccsessfulConfirm>
}