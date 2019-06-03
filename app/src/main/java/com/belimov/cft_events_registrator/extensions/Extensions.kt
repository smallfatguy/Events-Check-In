package com.belimov.cft_events_registrator.extensions

import com.belimov.cft_events_registrator.features.checkin.data.dto.ConfirmationDto
import com.belimov.cft_events_registrator.features.checkin.data.dto.ParticipantDto
import com.belimov.cft_events_registrator.features.checkin.domain.model.Participant
import com.belimov.cft_events_registrator.features.events.data.dto.EventDto
import com.belimov.cft_events_registrator.features.events.domain.model.Event
import java.text.SimpleDateFormat
import java.util.*

fun EventDto.getCitiesAsString(): String =
        this.cities.joinToString (separator = ",\n", transform = {it.nameRus })

fun EventDto.getDate(): Date =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).parse(this.date.start)

fun Event.getDateAsString(): String =
        SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(this.date)

fun ParticipantDto.getDate(): Date =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).parse(this.registeredDate)

fun Participant.transformToConfirmationDto(): List<ConfirmationDto> =
        listOf<ConfirmationDto>(ConfirmationDto(this.id, !this.isVisited, SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).format(Date())))